package com.spring.hibernate_advanced_demo.dao;

import com.spring.hibernate_advanced_demo.entity.Instructor;
import com.spring.hibernate_advanced_demo.entity.InstructorDetail;

public interface AppDao {
  void save(Instructor theInstructor);
  Instructor findInstructorById(int theId);
  void deleteInstructorById(int theId);
  InstructorDetail findInstructorDetailById(int theId);
  void deleteInstructorDetailById(int theId);
  void deleteInstructorDetail(int theId);
}
