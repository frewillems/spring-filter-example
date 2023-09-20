package com.example.dzopdemotestfilters.repository;

import com.example.dzopdemotestfilters.entity.Careplan;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareplanRepository extends CrudRepository<Careplan, Integer>, PagingAndSortingRepository<Careplan, Integer>, JpaSpecificationExecutor<Careplan> {
    //
}
