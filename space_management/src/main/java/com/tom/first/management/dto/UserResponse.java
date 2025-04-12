package com.tom.first.management.dto;

import java.util.Set;

import com.tom.first.management.model.enums.Profile;

public record UserResponse(String Nome, String Email, Set<Profile> Profiles) {

}
