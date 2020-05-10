package com.naresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
