package com.example.dzopdemotestfilters.service;

import com.example.dzopdemotestfilters.entity.User;
import com.example.dzopdemotestfilters.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> get(Specification<User> spec, Pageable paging) {
        return userRepository.findAll(spec, paging);
    }
}
