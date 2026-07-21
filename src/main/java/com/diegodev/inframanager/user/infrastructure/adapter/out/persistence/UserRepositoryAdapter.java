package com.diegodev.inframanager.user.infrastructure.adapter.out.persistence;

import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        return mapper.toDomainFromEntity(
                repository.save(
                        mapper.toEntity(user)
                )
        );
    }

    @Override
    public Optional<User> getById(UUID id) {
        if(repository.findById(id).isPresent()){
            return Optional.of(
                    mapper.toDomainFromEntity(
                            repository.findById(id).get()
                    )
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        if(repository.findByEmail(email).isPresent()){
            return Optional.of(
                    mapper.toDomainFromEntity(
                            repository.findByEmail(email).get()
                    )
            );
        }


        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDomainFromEntity)
                .toList();
    }

    @Override
    public void delete(UUID id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
