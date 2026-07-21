package com.diegodev.inframanager.user.domain.port.in;

import com.diegodev.inframanager.user.domain.model.User;

import java.util.List;
import java.util.UUID;


//Caso de uso, es una interfaz para los servicios del dominio
public interface UserUseCase {
    User createUser(User user);
    User getById(UUID id);
    List<User> getAll();
    User userUpdate(User user);
}
