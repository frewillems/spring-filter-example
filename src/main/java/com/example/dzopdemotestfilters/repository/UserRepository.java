package com.example.dzopdemotestfilters.repository;

import com.example.dzopdemotestfilters.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer>, JpaSpecificationExecutor<User> {
    //
}
