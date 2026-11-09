package com.spring.hibernate_advanced_demo.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.spring.hibernate_advanced_demo.entity.Instructor;

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
  
}
