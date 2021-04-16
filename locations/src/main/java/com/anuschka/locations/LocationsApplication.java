package com.anuschka.locations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *it will automatically scan the components in the current package and its sub-packages.
 * Thus it will register them in Spring's Application Context, and allow us to inject beans using @Autowired
 */
@SpringBootApplication
public class LocationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationsApplication.class, args);
	}

}
