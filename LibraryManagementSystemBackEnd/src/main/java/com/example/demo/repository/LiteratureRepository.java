package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Literature;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Integer>{

}
