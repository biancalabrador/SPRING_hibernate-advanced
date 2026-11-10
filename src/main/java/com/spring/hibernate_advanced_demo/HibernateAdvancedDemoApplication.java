package com.spring.hibernate_advanced_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.spring.hibernate_advanced_demo.dao.AppDao;
import com.spring.hibernate_advanced_demo.entity.Instructor;
import com.spring.hibernate_advanced_demo.entity.InstructorDetail;

@SpringBootApplication
public class HibernateAdvancedDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvancedDemoApplication.class, args);
	}

  @Bean 
  CommandLineRunner commandLineRunner(AppDao app) {
    return runner -> {
      // createInstructor(app);
      // findInstructor(app);
      // deleteInstructor(app);
      // findInstructorDetail(app);
      deleteInstructorDetail(app);
    };
  }

  // private void createInstructor(AppDao app) {
  //   Instructor ins = new Instructor("Leo",
  //                                   "Abasula",
  //                                   "maxverstappen@example.com");
  //   InstructorDetail deets = new InstructorDetail("Quantum",
  //                                   "Kpop");

  //   ins.setInstructorDetail(deets);

  //   System.out.println("Information saved!");
  //   app.save(ins);
  // }

  // private void findInstructor(AppDao app) {
  //   int id = 1;
  //   Instructor ins = app.findInstructorById(id);
  //   System.out.println("Instructor found: " + ins);
  //   System.out.println("Instructor details: " + ins.getInstructorDetail());
  // }

  // private void deleteInstructor(AppDao app) {
  //   int id = 1;
  //   System.out.println("Deleting instructor with id: " + id);
  //   app.deleteInstructorById(id);
  //   System.out.println("Instructor deleted!");
  // }

  // private void findInstructorDetail(AppDao app) {
  //   int id = 2;
  //   InstructorDetail inDeets = app.findInstructorDetailById(id);
  //   System.out.println("Details: " + inDeets);
  //   System.out.println("Instructor: " + inDeets.getInstructor());
  // }

  private void deleteInstructorDetail(AppDao app) {
    int id = 2;
    System.out.println("Deleting instructor details with id: " + id);
    app.deleteInstructorDetail(id);
    System.out.println("Instructor details deleted!");
  }
}
