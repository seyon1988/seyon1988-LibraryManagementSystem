package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Lend;

@Repository
public interface LendRepository extends JpaRepository<Lend, Integer> {

}
