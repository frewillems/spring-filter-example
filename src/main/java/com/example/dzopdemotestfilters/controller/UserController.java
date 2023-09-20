package com.example.dzopdemotestfilters.controller;

import com.example.dzopdemotestfilters.entity.User;
import com.example.dzopdemotestfilters.response.ListResponse;
import com.example.dzopdemotestfilters.response.ResponsePaging;
import com.example.dzopdemotestfilters.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<User> get(@And({
            @Spec(path = "id", params = "id", spec = Equal.class),
            @Spec(path = "firstName", params = "firstName", spec = Like.class),
            @Spec(path = "lastName", params = "lastName", spec = Like.class),
            @Spec(path = "email", params = "email", spec = Equal.class),
    }) Specification<User> spec, Pageable pageable) {
        Page<User> response = userService.get(spec, pageable);
        return new ListResponse<>(response.getContent(), new ResponsePaging(response.getTotalElements(), (long) response.getNumber(), (long) response.getSize(), (long) response.getTotalPages()));
    }
}
