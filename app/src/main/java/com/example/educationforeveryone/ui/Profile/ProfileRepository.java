package com.example.educationforeveryone.ui.Profile;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {

    private final MutableLiveData<ProfileModel> liveData;

    public ProfileRepository(){
        liveData = new MutableLiveData<>();
        setData();
    }

    private void setData() {

        List<String> skills = new ArrayList<>();
        skills.add("futbol");
        skills.add("am");
        skills.add("italyanca");
        skills.add("fenerbahçe sikmek");
        ProfileModel profileModel = new ProfileModel("Fatih Terim","Türkiyenin en taşşaklı tanrısı",skills);
        liveData.setValue(profileModel);

    }

    public MutableLiveData<ProfileModel> getLiveData(){
        return liveData;
    }

}
