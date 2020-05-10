package com.naresh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naresh.model.Customer;
import com.naresh.model.Orders;
import com.naresh.repository.CustomerRepository;
import com.naresh.repository.OrdersRepostiory;


@SpringBootApplication
public class SpringbootWithOneToManyExampleApplication implements CommandLineRunner {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrdersRepostiory ordersRepostiory;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithOneToManyExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Orders order = new Orders(9011, "TV", 50000.0);
		Orders order1 = new Orders(9022, "LAP", 51400.0);
		Orders order2 = new Orders(9028, "AC", 51400.0);
		Customer c = new Customer(101, "Naresh", 9550119431L);
		
	}
	
	
}
