package com.naresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {

}
