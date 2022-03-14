package com.sam.hibernateandjpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    // Oracle要設置GenerationType.SEQUENCE
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    // 這邊的sequenceName對應DB的sequence
    @SequenceGenerator(sequenceName = "courseseq", allocationSize = 1, name = "course_seq")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "LAST_UPDATE_DATE",nullable = false)
    private Timestamp lastUpdateDate;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<Review>();

    public Course() {
    }

    public Course(Integer id, String name, Timestamp createDate, Timestamp lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
        this.reviews.add(review);
    }

    public void removeReviews(Review review) {
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
