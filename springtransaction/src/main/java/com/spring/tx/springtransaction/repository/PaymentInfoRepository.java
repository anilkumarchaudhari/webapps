package com.spring.tx.springtransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tx.springtransaction.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
