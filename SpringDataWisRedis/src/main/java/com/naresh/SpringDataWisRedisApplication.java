package com.naresh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naresh.model.Student;
import com.naresh.repository.StudentRepository;

@SpringBootApplication
public class SpringDataWisRedisApplication  implements CommandLineRunner{

	@Autowired
	StudentRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataWisRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//adding data to redis database 
		/*
		 * Student student = new Student( "nit2541", "Naresh", Student.Gender.MALE, 1);
		 * repo.save(student);
		 */
		
		//getting data from redis database 
		List<Student> students = new ArrayList<>();
		repo.findAll().forEach(students::add);
		students.forEach(s->System.out.println(s.getName()));
	}
	
	/*
	 * https://github.com/tporadowski/redis/releases
	 */	
	
	

}
