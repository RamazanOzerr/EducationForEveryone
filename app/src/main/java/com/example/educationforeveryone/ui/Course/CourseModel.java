package com.example.educationforeveryone.ui.Course;

public class CourseModel {
    private  String publisher, courseName;

    public CourseModel(String publisher, String courseName) {
        this.publisher = publisher;
        this.courseName = courseName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
