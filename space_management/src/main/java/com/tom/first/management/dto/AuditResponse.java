package com.tom.first.management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.tom.first.management.model.User;

public record AuditResponse(

		String User, String Action, LocalDate Date, LocalTime Hour, String Details

) {
	public AuditResponse(User user, String action, LocalDateTime date, String details) {
		this(new UserNameDTO(user).users(), action, date.toLocalDate(), date.toLocalTime(), details);

	}

	public record UserNameDTO(String users) {
		public UserNameDTO(User user) {
			this(user != null && user.getName() != null ? user.getName() : "System");
		}
	}

}
