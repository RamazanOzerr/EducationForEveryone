package com.example.educationforeveryone.ui.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationforeveryone.databinding.SolutionPostRecyclerRowBinding;
import com.example.educationforeveryone.ui.Post.Question;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SolutionPostAdapter extends RecyclerView.Adapter<SolutionPostAdapter.PostHolder> {

    private ArrayList<Question> solutionList;

    public SolutionPostAdapter(ArrayList<Question> solutionList) {
        this.solutionList = solutionList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SolutionPostRecyclerRowBinding activityQuestionSolutionPostRecyclerRowBinding = SolutionPostRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(activityQuestionSolutionPostRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.activityQuestionSolutionPostRecyclerRowBinding.recyclerViewUserEmailText.setText(solutionList.get(position).mail);
        Picasso.get().load(solutionList.get(position).downloadUrl).into(holder.activityQuestionSolutionPostRecyclerRowBinding.imageView);
    }

    @Override
    public int getItemCount() {
        return solutionList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{

        SolutionPostRecyclerRowBinding activityQuestionSolutionPostRecyclerRowBinding;
        public PostHolder(SolutionPostRecyclerRowBinding activityQuestionSolutionPostRecyclerRowBinding) {
            super(activityQuestionSolutionPostRecyclerRowBinding.getRoot());
            this.activityQuestionSolutionPostRecyclerRowBinding = activityQuestionSolutionPostRecyclerRowBinding;
        }
    }

}