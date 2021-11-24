package com.proyecto.Labweb.services;


import com.proyecto.Labweb.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    public Iterable<User> findAll();

    public Page<User> findAll(Pageable pegeable);

    public Optional<User> findById(Long id);

    public User save(User user);

    public void deleteById(Long id);
}
