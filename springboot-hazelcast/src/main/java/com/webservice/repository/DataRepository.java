package com.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webservice.model.Data;

@Repository
public interface DataRepository extends CrudRepository<Data, Long> {
    
}
