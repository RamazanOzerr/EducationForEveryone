package com.example.educationforeveryone.ui.CourseInfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.educationforeveryone.ui.UserProfile.UserProfileModel;
import com.example.educationforeveryone.ui.UserProfile.UserProfileRepository;

public class CourseInfoViewModel extends ViewModel {

    private final MutableLiveData<CourseInfoModel> liveData;

    public CourseInfoViewModel(){
        CourseInfoRepository repository = new CourseInfoRepository();
        liveData = repository.getLiveData();
    }

    public MutableLiveData<CourseInfoModel> getData(){ return liveData;}
}
