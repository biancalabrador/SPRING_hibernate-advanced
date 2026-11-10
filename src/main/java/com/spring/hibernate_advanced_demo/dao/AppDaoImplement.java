package com.spring.hibernate_advanced_demo.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.spring.hibernate_advanced_demo.entity.Instructor;
import com.spring.hibernate_advanced_demo.entity.InstructorDetail;
import com.spring.hibernate_advanced_demo.dao.AppDao;

@Repository 
public class AppDaoImplement implements AppDao {

  private EntityManager em;

  public AppDaoImplement(EntityManager em) {
    this.em = em;
  }

  @Override 
  @Transactional
  public void save(Instructor theInstructor) {
    em.persist(theInstructor);
  }
  
  @Override 
    public Instructor findInstructorById(int theId) {
      return em.find(Instructor.class, theId);
    }

  @Override
  @Transactional
  public void deleteInstructorById(int theId) {
    Instructor in = em.find(Instructor.class, theId);
      em.remove(in);
  }

  @Override
  public InstructorDetail findInstructorDetailById(int theId) {
    return em.find(InstructorDetail.class, theId);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int theId) {
    InstructorDetail inDeets = em.find(InstructorDetail.class, theId);
    em.remove(inDeets);
  }

}
