package com.spring.batch.batchapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidLoginRepository extends JpaRepository<InvalidLoginData, Integer> {

}
