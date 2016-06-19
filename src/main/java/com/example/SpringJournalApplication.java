package com.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Journal;
import com.example.repository.JournalRepository;

@SpringBootApplication
public class SpringJournalApplication {
	
	@Bean
	InitializingBean saveDataAtStartup(JournalRepository repository){
		return ()->{
			repository.save(new Journal("01/01/2016","spring boot","today i started using spring boot"));
			repository.save(new Journal("07/01/2016","spring boot mvc","today i started using spring boot"
					+ "with mvc"));
			repository.save(new Journal("21/01/2016","spring boo jpa","today i started using spring boot"
					+ "with java persistance api"));
			repository.save(new Journal("11/02/2016","spring boot cloud","today i started using spring boot"
					+ "for the cloud"));
		};
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJournalApplication.class, args);
		
	}
}
