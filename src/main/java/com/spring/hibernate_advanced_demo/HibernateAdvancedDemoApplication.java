package com.spring.hibernate_advanced_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.spring.hibernate_advanced_demo.dao.AppDao;
import com.spring.hibernate_advanced_demo.entity.Instructor;

@SpringBootApplication
public class HibernateAdvancedDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvancedDemoApplication.class, args);
	}

  @Bean 
  CommandLineRunner commandLineRunner(AppDao app) {
    return runner -> {
      createInstructor(app);
    };
  }

  private void createInstructor(AppDao app) {
    Instructor ins = new Instructor("Vicky",
                                    "Magtanggol",
                                    "vicky.mags@example.com");
    InstructorDetails deets = new InstructorDetails("Math",
                                    "Solving probelms");

    ins.setInstructorDetails(deets);

    System.out.println("Information saved!");
    app.save(ins);
  }
}
