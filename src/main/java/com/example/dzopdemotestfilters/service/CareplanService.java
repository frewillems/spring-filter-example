package com.example.dzopdemotestfilters.service;

import com.example.dzopdemotestfilters.entity.Careplan;
import com.example.dzopdemotestfilters.repository.CareplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CareplanService {
    private final CareplanRepository careplanRepository;

    @Autowired
    public CareplanService(CareplanRepository careplanRepository) {
        this.careplanRepository = careplanRepository;
    }

    public Page<Careplan> get(Specification<Careplan> spec, Pageable paging) {
        return careplanRepository.findAll(spec, paging);
    }

    public Optional<Careplan> getById(Integer id) {
        return careplanRepository.findById(id);
    }
}
