package com.example.educationforeveryone.ui.Course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.educationforeveryone.databinding.FragmentCourseListBinding;
import com.example.educationforeveryone.ui.Adapter.CoursePostAdapter;
import com.example.educationforeveryone.ui.Post.Course;
import com.example.educationforeveryone.ui.message.ChatsViewModel;
import com.example.educationforeveryone.ui.question.QuestionViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseListFragment extends Fragment {

    private List<CourseModel> courseList;
    private FragmentCourseListBinding binding;

    private CourseAdapter courseAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCourseListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CourseViewModel courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);
        init();
       courseViewModel.getCourses().observe(getViewLifecycleOwner(), new Observer<List<CourseModel>>() {
           @Override
           public void onChanged(List<CourseModel> courseModels) {
               courseList.clear();
               courseList.addAll(courseModels);
               courseAdapter = new CourseAdapter(courseList);
                binding.recyclerViewChatsFragment.setAdapter(courseAdapter);

           }
       });

        return root;
    }

    private void init(){
        courseList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerViewChatsFragment.setLayoutManager(layoutManager);

//        MaterialToolbar toolbar = binding.toolbarChatsFragment;
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//
    }



//
//    public void getData() {
//        firebaseFirestore.collection("coursePost").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if (error != null) {
//                    Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                }
//                if (value != null) {
//                    for (DocumentSnapshot snapshot : value.getDocuments()) {
//                        Map<String, Object> data = snapshot.getData();
//                        String email = (String) data.get("usermail");
//                        String lesson = (String) data.get("lesson");
//                        String year = (String) data.get("year");
//                        Course post = new Course(email, year, lesson);
//                        courseListe.add(post);
//
//                    }
//                    coursePostAdapter.notifyDataSetChanged();
//                }
//            }
//        });
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}