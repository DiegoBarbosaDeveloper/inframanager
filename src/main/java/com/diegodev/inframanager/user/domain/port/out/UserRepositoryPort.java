package com.diegodev.inframanager.user.domain.port.out;

import com.diegodev.inframanager.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Interfaz que simula un crud simple de un repositorio
public interface UserRepositoryPort {
    User save(User user);
    Optional<User> getById(UUID id);
    Optional<User> getByEmail(String email);
    List<User> getAll();
    void delete(UUID id);
}
