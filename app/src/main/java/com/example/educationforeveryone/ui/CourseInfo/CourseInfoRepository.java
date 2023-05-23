package com.example.educationforeveryone.ui.CourseInfo;

import androidx.lifecycle.MutableLiveData;

import com.example.educationforeveryone.ui.UserProfile.UserProfileModel;

import java.util.ArrayList;
import java.util.List;

public class CourseInfoRepository {

    private final MutableLiveData<CourseInfoModel> liveData;

    public CourseInfoRepository(){
        liveData = new MutableLiveData<>();
        setData();
    }

    private void setData() {

        CourseInfoModel course = new CourseInfoModel("fatih terim", "tanrı",
                "how to fuck fenerbahçe properly",
                "31.31.3131","adult");

        liveData.setValue(course);
    }

    public MutableLiveData<CourseInfoModel> getLiveData(){
        return liveData;
    }

}
