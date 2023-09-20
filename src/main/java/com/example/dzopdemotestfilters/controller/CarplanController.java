package com.example.dzopdemotestfilters.controller;

import com.example.dzopdemotestfilters.entity.Careplan;
import com.example.dzopdemotestfilters.response.DetailResponse;
import com.example.dzopdemotestfilters.response.ListResponse;
import com.example.dzopdemotestfilters.response.ResponsePaging;
import com.example.dzopdemotestfilters.service.CareplanService;
import lombok.extern.slf4j.Slf4j;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/careplan")
public class CarplanController {
    private final CareplanService careplanService;

    @Autowired
    public CarplanController(CareplanService careplanService) {
        this.careplanService = careplanService;
    }

    @Transactional
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<Careplan> get(@And({@Spec(path = "status", params = "status", spec = Like.class), @Spec(path = "userId", params = "userId", spec = Like.class)}) Specification<Careplan> spec, Pageable pageable) {
        Page<Careplan> response = careplanService.get(spec, pageable);
        return new ListResponse<>(response.getContent(), new ResponsePaging(response.getTotalElements(), (long) response.getNumber(), (long) response.getSize(), response.getTotalElements()));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DetailResponse<Careplan> get(@PathVariable(name = "id") Integer id) {
        Optional<Careplan> response = careplanService.getById(id);
        return new DetailResponse<>(response.get());
    }
}
