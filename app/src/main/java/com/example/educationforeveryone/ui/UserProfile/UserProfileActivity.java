package com.example.educationforeveryone.ui.UserProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.educationforeveryone.R;
import com.example.educationforeveryone.databinding.ActivityUserProfileBinding;
import com.r0adkll.slidr.Slidr;

public class UserProfileActivity extends AppCompatActivity {

    ActivityUserProfileBinding binding;
    UserProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        viewModel.getData().observe(this, this::updateData);

        Slidr.attach(this);
    }

    private void updateData(UserProfileModel userProfileModel){
        binding.textUsernameUserprofile.setText(userProfileModel.getUsername());
        binding.textBioUserprofile.setText(userProfileModel.getBio());
        StringBuilder temp = new StringBuilder();
        for(String str : userProfileModel.getSkills()){
            temp.append(str).append(", ");
        }
        binding.textSkillsProfile.setText(temp);
    }
}