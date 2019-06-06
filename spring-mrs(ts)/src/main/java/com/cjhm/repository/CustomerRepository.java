package com.cjhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjhm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
