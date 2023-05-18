package com.example.educationforeveryone.ui.Course;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationforeveryone.R;
import com.example.educationforeveryone.ui.message.ChatAdapter;

import java.util.ArrayList;
import java.util.List;

import io.grpc.Context;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private List<CourseModel> courseModelList;

    private List<CourseModel> courseModelListFull;

    private View view;

    Activity activity;

    Context context;

    public CourseAdapter(List<CourseModel> courseModelList) {
        this.courseModelList = courseModelList;
        courseModelListFull = new ArrayList<>(courseModelList);
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



    }

    @Override
    public int getItemCount() {
        return courseModelList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        private AppCompatTextView text_view_lesson,text_view_email,text_view_class ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            text_view_class = itemView.findViewById(R.id.recyclerViewUserYearText);
            text_view_lesson = itemView.findViewById(R.id.recyclerViewUserLessonText);
            text_view_email = itemView.findViewById(R.id.recyclerViewUserEmailText);
        }


    }




}
