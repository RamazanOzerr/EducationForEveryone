package com.example.educationforeveryone.ui.Course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.educationforeveryone.databinding.FragmentCourseListBinding;
import com.example.educationforeveryone.ui.Adapter.CoursePostAdapter;
import com.example.educationforeveryone.ui.Post.Course;
import com.example.educationforeveryone.ui.question.QuestionViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class CourseListFragment extends Fragment {

    private ArrayList<Course> courseListe;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;
    private FragmentCourseListBinding binding;

    private CoursePostAdapter coursePostAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        QuestionViewModel homeViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        binding = FragmentCourseListBinding.inflate(inflater, container, false);
        courseListe = new ArrayList<>();
        View root = binding.getRoot();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        getData();
        binding.courseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        coursePostAdapter = new CoursePostAdapter(courseListe);
        binding.courseRecyclerView.setAdapter(coursePostAdapter);
        return root;
    }

    public void getData() {
        firebaseFirestore.collection("coursePost").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if (value != null) {
                    for (DocumentSnapshot snapshot : value.getDocuments()) {
                        Map<String, Object> data = snapshot.getData();
                        String email = (String) data.get("usermail");
                        String lesson = (String) data.get("lesson");
                        String year = (String) data.get("year");
                        Course post = new Course(email, year, lesson);
                        courseListe.add(post);

                    }
                    coursePostAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}