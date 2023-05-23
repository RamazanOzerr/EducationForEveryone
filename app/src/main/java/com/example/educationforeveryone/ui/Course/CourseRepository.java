package com.example.educationforeveryone.ui.Course;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {


    private final MutableLiveData<List<CourseModel>> liveData;
    private final List<CourseModel> courseModelList;


    public CourseRepository() {
        this.liveData = new MutableLiveData<>();
        this.courseModelList = new ArrayList<>();
    }


    public MutableLiveData<List<CourseModel>> getCourses(){

        CourseModel courseModel = new CourseModel("Matematik","963","deneme@gmail.com");
        CourseModel courseModel1 = new CourseModel("türkçe","852","deneme2@gmail.com");
        CourseModel courseModel2 = new CourseModel("ingilzice","741","deneme3@gmail.com");
        CourseModel courseModel3 = new CourseModel("fen bilgisi","789","deneme4@gmail.com");
        CourseModel courseModel4 = new CourseModel("inkilap","456","deneme5@gmail.com");
        CourseModel courseModel5 = new CourseModel("haya bilgisi","123","deneme6@gmail.com");

        courseModelList.add(courseModel2);
        courseModelList.add(courseModel1);
        courseModelList.add(courseModel);
        courseModelList.add(courseModel4);
        courseModelList.add(courseModel5);
        courseModelList.add(courseModel);
        courseModelList.add(courseModel3);
        courseModelList.add(courseModel);
        courseModelList.add(courseModel1);
        courseModelList.add(courseModel4);
        courseModelList.add(courseModel3);
        courseModelList.add(courseModel);
        courseModelList.add(courseModel3);
        courseModelList.add(courseModel);


        liveData.setValue(courseModelList);

        return liveData;



    }
}
