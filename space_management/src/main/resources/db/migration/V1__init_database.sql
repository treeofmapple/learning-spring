CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE profile (
    id_user INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    profile VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_user, profile)
);

CREATE TABLE physical_space (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type_space VARCHAR(50) NOT NULL,
    size_space NUMERIC(5, 2) NOT NULL,
    availability VARCHAR(25) NOT NULL CHECK (availability IN ('AVAILABLE', 'UNAVAILABLE'))
);

CREATE TABLE equipament (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE space_equipament (
    id INT NOT NULL REFERENCES physical_space(id) ON DELETE CASCADE,
    equipament_id INT NOT NULL REFERENCES equipament(id) ON DELETE CASCADE,
    PRIMARY KEY (id, equipament_id)
);

CREATE TABLE evaluator (
    id SERIAL PRIMARY KEY,
    id_evaluator INT NOT NULL REFERENCES users(id)
);

CREATE TABLE solicitation (
    id SERIAL PRIMARY KEY,
    id_space INT NOT NULL REFERENCES physical_space(id), 
    id_solicitator INT NOT NULL REFERENCES users(id),
    id_evaluator INT REFERENCES evaluator(id),
    name VARCHAR(255) NOT NULL,
    date_start TIMESTAMP NOT NULL,
    date_end TIMESTAMP NOT NULL,
    hour_start TIME NOT NULL,
    hour_end TIME NOT NULL,
    date_solicitation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_evaluation TIMESTAMP,
    status VARCHAR(50) NOT NULL CHECK (status IN ('APPROVED', 'REJECTED', 'PENDING')), 
    justification TEXT
);

CREATE TABLE audit (
    id SERIAL PRIMARY KEY,
    id_user INT REFERENCES users(id),
    actions VARCHAR(255) NOT NULL,
    date_audit TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    details TEXT
);

CREATE TABLE holiday (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_holiday DATE NOT NULL UNIQUE
);

CREATE OR REPLACE FUNCTION process_user_to_evaluator()
RETURNS VOID AS $$
DECLARE
    user_record RECORD;
BEGIN
    FOR user_record IN
        SELECT p.id_user
        FROM profile p
        LEFT JOIN evaluator e ON p.id_user = e.id_evaluator
        WHERE p.profile IN ('GESTOR', 'ADMINISTRADOR')
          AND e.id_evaluator IS NULL
    LOOP
        INSERT INTO evaluator (id_evaluator)
        VALUES (user_record.id_user);
    END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION trigger_profile_to_evaluator()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.profile IN ('GESTOR', 'ADMINISTRADOR') THEN
        IF NOT EXISTS (
            SELECT 1 FROM evaluator WHERE id_evaluator = NEW.id_user
        ) THEN
            INSERT INTO evaluator (id_evaluator)
            VALUES (NEW.id_user);
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_profile_insert
AFTER INSERT OR UPDATE ON profile
FOR EACH ROW
EXECUTE FUNCTION trigger_profile_to_evaluator();

CREATE OR REPLACE FUNCTION check_overlap()
RETURNS TRIGGER AS $$
DECLARE
    weekday INT;
    start_dt TIMESTAMP;
    end_dt TIMESTAMP;
    holiday_date DATE;
    existing RECORD;
BEGIN
    start_dt := NEW.date_start + NEW.hour_start;
    end_dt := NEW.date_end + NEW.hour_end;

    IF (EXTRACT(HOUR FROM start_dt) < 7 OR EXTRACT(HOUR FROM end_dt) > 22) THEN
        RAISE EXCEPTION 'Time must be between 07:00 and 22:00';
    END IF;

    weekday := EXTRACT(DOW FROM start_dt);
    IF weekday = 0 THEN
        RAISE EXCEPTION 'Reservations are not allowed on Sundays';
    END IF;

    FOR holiday_date IN SELECT date_holiday FROM holiday LOOP
        IF NEW.date_start::DATE = holiday_date THEN
            RAISE EXCEPTION 'Reservations are not allowed on holidays';
        END IF;
    END LOOP;

    FOR existing IN
        SELECT * FROM solicitation
        WHERE id_space = NEW.id_space AND status = 'APPROVED'
    LOOP
        IF (existing.date_start + existing.hour_start, existing.date_end + existing.hour_end)
           OVERLAPS (start_dt, end_dt) THEN
            RAISE EXCEPTION 'Overlapping reservation detected!';
        END IF;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_check_overlap
BEFORE INSERT OR UPDATE ON solicitation
FOR EACH ROW
EXECUTE FUNCTION check_overlap();

CREATE OR REPLACE FUNCTION process_evaluation()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO audit (id_user, actions, details, date_audit)
    VALUES (
        NEW.id_evaluator,
        'Evaluated solicitation',
        'Solicitation ' || NEW.id || ' was ' || NEW.status,
        CURRENT_TIMESTAMP
    );

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_process_evaluation
AFTER UPDATE OF status ON solicitation
FOR EACH ROW
WHEN (NEW.status IN ('APPROVED', 'REJECTED'))
EXECUTE FUNCTION process_evaluation();


