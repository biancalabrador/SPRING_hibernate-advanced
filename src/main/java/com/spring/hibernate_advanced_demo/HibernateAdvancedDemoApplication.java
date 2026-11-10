package com.spring.hibernate_advanced_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.spring.hibernate_advanced_demo.dao.AppDao;
import com.spring.hibernate_advanced_demo.entity.Course;
import com.spring.hibernate_advanced_demo.entity.Instructor;
import com.spring.hibernate_advanced_demo.entity.InstructorDetail;
import com.spring.hibernate_advanced_demo.entity.Review;

import java.util.List;

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
      // deleteInstructorDetail(app);
      // createInstructorWithCourses(app);
      // findInstructorWithCourses(app);
      // findCoursesForInstructor(app);
      // findInstructorWithCoursesJoinFetch(app);
      // updateInstructor(app);
      createCourseAndReviews(app);
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

  // private void deleteInstructorDetail(AppDao app) {
  //   int id = 2;
  //   System.out.println("Deleting instructor details with id: " + id);
  //   app.deleteInstructorDetail(id);
  //   System.out.println("Instructor details deleted!");
  // }

  // private void createInstructorWithCourses(AppDao app) {
  //   Instructor ins = new Instructor("Farrah",
  //                                   "Magana",
  //                                   "farrahway@example.com");
  //   InstructorDetail deets = new InstructorDetail("Leadership",
  //                                   "Reading");
  //   ins.setInstructorDetail(deets);
  //   Course course1 = new Course("SRA");
  //   Course course2 = new Course("English");
  //   ins.addCourse(course1);
  //   ins.addCourse(course2);
  //   System.out.println("Saving instructor: " + ins);
  //   app.save(ins);
  // }

  // private void findInstructorWithCourses(AppDao app) {
  //   int id = 8;
  //   System.out.println("Finding instructor with id: " + id);
  //   Instructor ins = app.findInstructorById(id);
  //   System.out.println("Instructor: " + ins);
  //   System.out.println("Courses: " + ins.getClass());
  // }

  // private void findCoursesForInstructor(AppDao app) {
  //   int id = 2;
  //   System.out.println("Find instructor id: " + id);
  //   Instructor ins = app.findInstructorById(id);
  //   System.out.println("Instructor: " + ins);
  //   System.out.println("Courses from id: " + id);
  //   List<Course> courses = app.findCoursesByInstructorId(id);
  //   ins.setCourses(courses);
  //   System.out.println(ins.getCourses());
  // }

  // private void findInstructorWithCoursesJoinFetch(AppDao app) {
  //   int id = 7;
  //   System.out.println("Find instructor id: " + id);
  //   Instructor ins = app.findInstructorByIdJoinFetch(id);
  //   System.out.println("Instructor: " + ins);
  //   System.out.println("Courses: " + ins.getCourses());
  // }

  // private void updateInstructor(AppDao app) {
  //   int id = 7;
  //   System.out.println("Find instructor id: " + id);
  //   Instructor ins = app.findInstructorById(id);
  //   ins.setLastName("Reeves");
  //   System.out.println("Updated!");
  //   app.update(ins);
  // }

  private void createCourseAndReviews(AppDao app) {
    Course course = new Course("How to Speed Run Spring in 1 Day");
    course.addReview(new Review("Great speed 2x... loved it!"));
    course.addReview(new Review("Amen"));
    course.addReview(new Review("Kachow"));
    System.out.println("Course saved!");
    app.save(course);
  }
}
