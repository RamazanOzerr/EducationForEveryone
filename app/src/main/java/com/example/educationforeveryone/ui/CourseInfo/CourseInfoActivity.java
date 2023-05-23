package com.example.educationforeveryone.ui.CourseInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.educationforeveryone.R;
import com.example.educationforeveryone.databinding.ActivityCourseInfoBinding;
import com.example.educationforeveryone.databinding.ActivityUserProfileBinding;
import com.example.educationforeveryone.ui.UserProfile.UserProfileViewModel;
import com.r0adkll.slidr.Slidr;

public class CourseInfoActivity extends AppCompatActivity {

    ActivityCourseInfoBinding binding;
    CourseInfoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(CourseInfoViewModel.class);

        viewModel.getData().observe(this, new Observer<CourseInfoModel>() {
            @Override
            public void onChanged(CourseInfoModel courseInfoModel) {
                updateData(courseInfoModel);
            }
        });

        Slidr.attach(this);
    }

    private void updateData(CourseInfoModel courseInfoModel){

    }
}