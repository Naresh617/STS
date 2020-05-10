package com.naresh;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.naresh.model.Passport;
import com.naresh.model.Person;
import com.naresh.repository.PassportRepository;

@SpringBootApplication
public class SpringbootWithOneToOneFkApplication implements CommandLineRunner {
   
	@Autowired
	ApplicationContext appctx;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithOneToOneFkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PassportRepository passportRepository=(PassportRepository)appctx.getBean("passportRepository");
		
		Person p =new Person(101,"Naresh");
		
		Passport passport=new Passport();
		passport.setPassportId(94715);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
	    try {  
	    	Date date  = formatter.parse("31-12-2025");  
	    	 passport.setExpireDate(date);
	    } catch (ParseException e) {e.printStackTrace();}  
	    passport.setPerson(p);
	    
	    passportRepository.save(passport);
	   
	}  

}
