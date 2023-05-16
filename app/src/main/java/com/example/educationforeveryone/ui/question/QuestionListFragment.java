package com.example.educationforeveryone.ui.question;

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

import com.example.educationforeveryone.databinding.FragmentQuestionListBinding;
import com.example.educationforeveryone.ui.Adapter.QuestionPostAdapter;
import com.example.educationforeveryone.ui.Post.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class QuestionListFragment extends Fragment {

    private ArrayList<Question> liste;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;
    private FragmentQuestionListBinding binding;

    private QuestionPostAdapter questionPostAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        QuestionViewModel homeViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        binding = FragmentQuestionListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        liste = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        getData();
        binding.questionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        questionPostAdapter = new QuestionPostAdapter(liste);
        binding.questionRecyclerView.setAdapter(questionPostAdapter);
        return root;
    }

    public void getData() {
        firebaseFirestore.collection("Question").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if (value != null) {
                    for (DocumentSnapshot snapshot : value.getDocuments()) {
                        Map<String, Object> data = snapshot.getData();
                        String email = (String) data.get("usermail");
                        String downloadUrl = (String) data.get("downloadurl");
                        String id = (String) data.get("id");
                        Question post = new Question(email, downloadUrl, id);
                        liste.add(post);

                    }
                    questionPostAdapter.notifyDataSetChanged();
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