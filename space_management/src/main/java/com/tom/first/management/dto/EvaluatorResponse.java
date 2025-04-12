package com.tom.first.management.dto;

import java.util.Set;

import com.tom.first.management.model.User;
import com.tom.first.management.model.enums.Profile;

public record EvaluatorResponse(String Evaluator, Set<Profile> Profile) {
	public EvaluatorResponse(User evaluator) {
		this(evaluator.getName(), evaluator.getProfiles());
	}
}
