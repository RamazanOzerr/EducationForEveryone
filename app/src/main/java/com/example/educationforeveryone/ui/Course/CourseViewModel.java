package com.example.educationforeveryone.ui.Course;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CourseViewModel extends ViewModel {

    private final MutableLiveData<List<CourseModel>> liveData;


    public CourseViewModel() {

        CourseRepository repository = new CourseRepository();
        liveData = repository.getCourses();
    }

    public MutableLiveData<List<CourseModel>> getCourses() {return liveData;}

}