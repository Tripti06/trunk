package com.example.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EmpDetails;

@Repository
public interface EmpDataRepository extends CrudRepository<EmpDetails, String>, EmpDataCustom{
	List<EmpDetails> findByFirstName(String firstName);

}

    