package com.diegodev.inframanager.user.application;

import com.diegodev.inframanager.security.domain.port.out.PasswordEncoderPort;
import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.domain.port.in.UserUseCase;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getById(UUID id) {
        if(userRepository.getById(id).isPresent()) {
            return userRepository.getById(id).get();
        };
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User userUpdate(User user) {
        return null;
    }
}
