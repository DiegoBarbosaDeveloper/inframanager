package com.diegodev.inframanager.user.infrastructure.adapter.in.api;

import com.diegodev.inframanager.user.domain.port.in.UserUseCase;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.mapper.UserMapper;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserRequest;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Transactional
public class UserRestApiAdapter implements UserRestApi {

    private final UserUseCase userUseCase;

    private final UserMapper userMapper;

    public UserRestApiAdapter(UserUseCase userUseCase, UserMapper userMapper) {
        this.userUseCase = userUseCase;
        this.userMapper = userMapper;
    }


    @PostMapping
    @Override
    public ResponseEntity<UserResponse> saveUser(UserRequest request) {

        var user = userMapper.toDomainFromRequest(request);
        var created = userUseCase.createUser(user);

        return ResponseEntity.ok(userMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        var user = userUseCase.getById(id);
        var gotten = userMapper.toResponse(user);
        return ResponseEntity.ok(gotten);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userUseCase.getAll().stream()
                .map(userMapper::toResponse)
                .toList();

        return ResponseEntity.ok(userResponses);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        return null;
    }
}
