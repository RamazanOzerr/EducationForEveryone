package com.example.educationforeveryone.ui.Course;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationforeveryone.R;
import com.example.educationforeveryone.ui.CourseInfo.CourseInfoActivity;
import com.example.educationforeveryone.ui.UserProfile.UserProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private List<CourseModel> courseModelList;

    private List<CourseModel> courseModelListFull;

    private View view;

    Activity activity;

    android.content.Context context;

    public CourseAdapter(List<CourseModel> courseModelList, Activity activity, Context context) {
        this.courseModelList = courseModelList;
        courseModelListFull = new ArrayList<>(courseModelList);
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_post_recycler_row,
                parent,false);

        return new CourseAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    holder.text_view_email.setText(courseModelList.get(position).getEmail_str());
    holder.text_view_lesson.setText(courseModelList.get(position).getLesson_str());
    holder.text_view_class.setText(courseModelList.get(position).getClass_str());

    holder.constraint_course_item.setOnClickListener(view1 -> {
        activity.startActivity(new Intent(context, CourseInfoActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    });

    }

    @Override
    public int getItemCount() {
        return courseModelList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        private final AppCompatTextView text_view_lesson,text_view_email,text_view_class;
        private final ConstraintLayout constraint_course_item;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            text_view_class = itemView.findViewById(R.id.recyclerViewUserYearText);
            text_view_lesson = itemView.findViewById(R.id.recyclerViewUserLessonText);
            text_view_email = itemView.findViewById(R.id.recyclerViewUserEmailText);
            constraint_course_item = itemView.findViewById(R.id.constraint_course_item);
        }


    }




}
