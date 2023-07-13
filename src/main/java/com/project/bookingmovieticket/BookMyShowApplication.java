package com.project.bookingmovieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.cache.annotation.EnableCaching;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Avijit Roy
 * This is the application for booking movie ticket
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@Slf4j
public class BookMyShowApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
		log.info("Booking movie ticket application is started");
	}

}
