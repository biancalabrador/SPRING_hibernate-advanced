package com.spring.hibernate_advanced_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "review")
public class Review {
  
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "comments")
  private String comments;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  public Review(){
  }

  public Review(String comments){
    this.comments = comments;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public void add(Review rev) {
    this.comments = rev.comments;
  }

  @Override
  public String toString() {
    return "Review [id=" + id + ", comments=" + comments + "]";
  }

}
