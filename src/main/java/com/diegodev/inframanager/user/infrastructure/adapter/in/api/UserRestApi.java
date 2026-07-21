package com.diegodev.inframanager.user.infrastructure.adapter.in.api;

import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserRequest;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserRestApi {

    ResponseEntity<UserResponse> saveUser(UserRequest request);
    ResponseEntity<UserResponse> getUser(UUID id);
    ResponseEntity<List<UserResponse>> getAllUsers();
    ResponseEntity<UserResponse> updateUser(UUID id);
    ResponseEntity<Void> deleteUser(UUID id);


}
