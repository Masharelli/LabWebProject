package com.proyecto.Labweb.services;

import com.proyecto.Labweb.Entities.User;
import com.proyecto.Labweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceMpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)

    public Page<User> findAll(Pageable pegeable) {

        return userRepository.findAll(pegeable);
    }

    @Override
    @Transactional(readOnly = true)

    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        userRepository.deleteById(id);
    }
}
