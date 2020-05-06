package com.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootEhcacheExampleApplication implements CommandLineRunner{
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEhcacheExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for(int i=0;i<3;i++){
			System.out.println("\t\t"+bookRepository.getBook(1000));
			System.out.println("\t\t"+bookRepository.getBook(1001));
		}
		
	}
}
