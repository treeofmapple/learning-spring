package com.tom.first.management.mapper;

import org.springframework.stereotype.Service;

import com.tom.first.management.dto.EvaluationRequest;
import com.tom.first.management.dto.EvaluationResponse;
import com.tom.first.management.exception.NotFoundException;
import com.tom.first.management.model.Evaluation;
import com.tom.first.management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluationMapper {

	private final UserRepository repository;

	public Evaluation toEvaluation(EvaluationRequest request) {
		if (request == null) {
			return null;
		}

		return repository.findByName(request.name())
				.map(user -> Evaluation.builder().subject(request.subject()).description(request.description())
						.grade(request.grade()).user(user).build())
				.orElseThrow(() -> new NotFoundException("User with requested name doesn't exist: " + request.name()));
	}

	public EvaluationResponse fromEvaluation(Evaluation evaluation) {
		if (evaluation == null) {
			return null;
		}
		return new EvaluationResponse(evaluation.getSubject(), evaluation.getDescription(), evaluation.getGrade(),
				evaluation.getUser());
	}


}
