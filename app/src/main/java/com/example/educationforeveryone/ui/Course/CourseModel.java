package com.example.educationforeveryone.ui.Course;

public class CourseModel {
    private  String lesson_str,class_str,email_str;

    public CourseModel(String lesson_str, String class_str, String email_str) {
        this.lesson_str = lesson_str;
        this.class_str = class_str;
        this.email_str = email_str;
    }

    public String getLesson_str() {
        return lesson_str;
    }

    public void setLesson_str(String lesson_str) {
        this.lesson_str = lesson_str;
    }

    public String getClass_str() {
        return class_str;
    }

    public void setClass_str(String class_str) {
        this.class_str = class_str;
    }

    public String getEmail_str() {
        return email_str;
    }

    public void setEmail_str(String email_str) {
        this.email_str = email_str;
    }
}
