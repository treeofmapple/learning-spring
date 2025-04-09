package com.tom.first.management.common;

import java.util.Set;

import com.tom.first.management.dto.UserRequest;
import com.tom.first.management.model.User;

public class SystemFunctions {

	public void mergerUsuario(User usuario, UserRequest request) {
		usuario.setName(request.Name());
		usuario.setEmail(request.Email());
		usuario.setProfiles(request.Profiles() == null ? Set.of() : request.Profiles());
	}
	
}
