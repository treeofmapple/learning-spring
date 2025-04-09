package com.tom.first.management.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.tom.first.management.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solicitation")
public class Solicitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_space", nullable = false)
    private PhysicalSpace espaco;

    @ManyToOne
    @JoinColumn(name = "id_solicitator", nullable = false)
    private User solicitante;
    
    @ManyToOne
    @JoinColumn(name = "id_evaluator", nullable = true)
    private Evaluator avaliador;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;

    @Column(name = "hour_inicio", nullable = false)
    private LocalTime hourStart;

    @Column(name = "hour_fim", nullable = false)
    private LocalTime hourEnd;
    
    @Column(name = "date_solicitation", nullable = false)
    private LocalDate dateSolicitation;
    
    @Column(name = "date_evaluation", nullable = false)
    private LocalDate dataEvaluation;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String justification;
    
    @PrePersist
    public void prePersist() {
        if (dateSolicitation == null) {
            this.dateSolicitation = LocalDate.now();
        }
    }
	
}
