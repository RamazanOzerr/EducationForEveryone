package com.example.educationforeveryone.ui.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationforeveryone.databinding.CoursePostRecyclerRowBinding;
import com.example.educationforeveryone.ui.Post.Course;

import java.util.ArrayList;

public class CoursePostAdapter extends RecyclerView.Adapter<CoursePostAdapter.PostHolder>{

    private ArrayList<Course> courseList;

    public CoursePostAdapter(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CoursePostAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Satır görünümünü şişirme işlemi
        CoursePostRecyclerRowBinding coursePostRecyclerRowBinding = CoursePostRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CoursePostAdapter.PostHolder(coursePostRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, @SuppressLint("RecyclerView") int position) {
        // Her bir görünümün içeriğini ayarlama işlemi
        holder.coursePostRecyclerRowBinding.recyclerViewUserEmailText.setText(courseList.get(position).mail);
        holder.coursePostRecyclerRowBinding.recyclerViewUserYearText.setText(courseList.get(position).year);
        holder.coursePostRecyclerRowBinding.recyclerViewUserLessonText.setText(courseList.get(position).lesson);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Contact the Course Owner");
                alert.setMessage("Are You Sure to Contact the Course Owner: " + courseList.get(position).mail);
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //********************************************************************************************
                        //courseList.get(position).mail ile elde edilen mail adresli kişiye default mesaj gönderilecek.
                        //********************************************************************************************
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        // Görüntülenecek öğe sayısını döndürme işlemi
        return courseList.size();
    }

    // ViewHolder sınıfı
    class PostHolder extends RecyclerView.ViewHolder{
        CoursePostRecyclerRowBinding coursePostRecyclerRowBinding;
        public PostHolder(CoursePostRecyclerRowBinding coursePostRecyclerRowBinding) {
            super(coursePostRecyclerRowBinding.getRoot());
            this.coursePostRecyclerRowBinding = coursePostRecyclerRowBinding;
        }
    }
}