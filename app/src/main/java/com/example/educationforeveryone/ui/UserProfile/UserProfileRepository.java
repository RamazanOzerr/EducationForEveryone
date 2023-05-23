package com.example.educationforeveryone.ui.UserProfile;

import androidx.lifecycle.MutableLiveData;

import com.example.educationforeveryone.ui.Profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class UserProfileRepository {

    private final MutableLiveData<UserProfileModel> liveData;

    public UserProfileRepository(){
        liveData = new MutableLiveData<>();
        setData();
    }

    private void setData() {

        List<String> skills = new ArrayList<>();
        skills.add("futbol");
        skills.add("am");
        skills.add("italyanca");
        skills.add("fenerbahçe sikmek");
        UserProfileModel profileModel = new UserProfileModel("Fatih Terim","Türkiyenin en taşşaklı tanrısı",skills);
        liveData.setValue(profileModel);

    }

    public MutableLiveData<UserProfileModel> getLiveData(){
        return liveData;
    }

}
