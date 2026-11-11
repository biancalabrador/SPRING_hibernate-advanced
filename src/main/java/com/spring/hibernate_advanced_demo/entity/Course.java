package com.spring.hibernate_advanced_demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<Review> review;

  @ManyToOne (cascade = {
    CascadeType.DETACH,
    CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH
  })
  @JoinColumn (name = "instructor_id")
  private Instructor instructor;

  @ManyToMany(fetch = FetchType.LAZY,
              cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
              }
  )
  @JoinTable(name = "course_stduent",
            joinColumns = @JoinColumn (name = "course_id"),
            inverseJoinColumns = @JoinColumn (name = "student_id")
  )
  private List<Student> students;


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

  public List<Review> getReview() {
    return review;
  }

  public void setReview(List<Review> review) {
    this.review = review;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", title=" + title + "]";
  }

  public void addReview(Review rev) {
    if(review == null){
      review = new ArrayList<>();
    }
    review.add(rev);
    rev.setCourse(this);
  }

  public void addStudent(Student stud) {
    if(students == null){
      students = new ArrayList<>();
    }
    students.add(stud);
  }

  public EntityManager getStudents() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
  }
}
