package com.tom.first.management.mapper;

import org.springframework.stereotype.Service;

import com.tom.first.management.dto.UserRequest;
import com.tom.first.management.dto.UserResponse;
import com.tom.first.management.model.User;

@Service
public class UserMapper {

	public User toUser(UserRequest request) {
		if(request == null) {
			return null;
		}
		
		return User.builder()
				.name(request.Name())
				.email(request.Email())
				.profiles(request.Profiles())
				.build();
	}
	
	public UserResponse fromUser(User user) {
		return new UserResponse(
			user.getName(),
			user.getEmail(),
			user.getProfiles()
		);
	}	
}
