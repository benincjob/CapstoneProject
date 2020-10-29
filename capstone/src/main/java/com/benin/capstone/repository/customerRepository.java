package com.benin.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benin.capstone.model.customer;

@Repository
public interface customerRepository extends JpaRepository<customer, Long> {

}
