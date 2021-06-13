package com.spring.tx.springtransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tx.springtransaction.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
