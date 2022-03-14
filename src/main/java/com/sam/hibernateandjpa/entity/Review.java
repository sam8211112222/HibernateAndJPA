package com.sam.hibernateandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(sequenceName = "review_seq", allocationSize = 1, name = "review_seq")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(Integer id, Integer rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
