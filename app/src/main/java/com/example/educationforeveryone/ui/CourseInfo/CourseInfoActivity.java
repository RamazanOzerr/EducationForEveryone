package com.example.educationforeveryone.ui.CourseInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.educationforeveryone.R;
import com.example.educationforeveryone.databinding.ActivityCourseInfoBinding;
import com.example.educationforeveryone.databinding.ActivityUserProfileBinding;
import com.example.educationforeveryone.ui.CreateCourse.CreateCourseActivity;
import com.example.educationforeveryone.ui.UserProfile.UserProfileActivity;
import com.example.educationforeveryone.ui.UserProfile.UserProfileViewModel;
import com.r0adkll.slidr.Slidr;

public class CourseInfoActivity extends AppCompatActivity {

    ActivityCourseInfoBinding binding;
    CourseInfoViewModel viewModel;
    private String otherUser;

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
                otherUser = courseInfoModel.getPublisher_id();
            }
        });

        setListeners();
        Slidr.attach(this);
    }

    private void updateData(CourseInfoModel courseInfoModel){

    }


    private void setListeners(){
        binding.pImage.setOnClickListener(view -> {
            if(otherUser != null){
                Intent intent = new Intent(this, UserProfileActivity.class);
                intent.putExtra("otherUser", otherUser);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        binding.likeImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateCourseActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }
}