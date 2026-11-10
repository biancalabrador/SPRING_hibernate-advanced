package com.spring.hibernate_advanced_demo.entity;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
@Table (name = "course")
public class Course {

  @Id 
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "id")
  private int id;

  @Column (name = "title")
  private String title;

  @ManyToOne (cascade = {
    CascadeType.DETACH,
    CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH
  })
  @JoinColumn (name = "instructor_id")
  private Instructor instructor;

  public Course() {
  }

  public Course(String title) {
    this.title = title;
  }

  public void setInstructor(Instructor instructor2) {
    this.instructor = instructor2;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", title=" + title + "]";
  }

  

}
