package com.naresh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, String>{

}
