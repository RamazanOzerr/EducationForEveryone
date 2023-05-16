package com.example.educationforeveryone.ui.Solution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.educationforeveryone.MainActivity;
import com.example.educationforeveryone.databinding.ActivityQuestionSolutionBinding;
import com.example.educationforeveryone.ui.Adapter.SolutionPostAdapter;
import com.example.educationforeveryone.ui.Post.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class SolutionListActivity extends Activity {

    String questionid ;
    private ArrayList<Question> solutionListe;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;

    private SolutionPostAdapter SolutionPostAdapter;

    private ActivityQuestionSolutionBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionSolutionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        solutionListe = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        binding.questionSolutionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SolutionPostAdapter = new SolutionPostAdapter(solutionListe);
        binding.questionSolutionRecyclerView.setAdapter(SolutionPostAdapter);

        Intent intent = getIntent();
        questionid = (String) intent.getSerializableExtra("id");
        getData();

    }

    public void getData() {
        String postName = "Solution" + questionid;

        firebaseFirestore.collection(postName).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if (value != null) {
                    for (DocumentSnapshot snapshot : value.getDocuments()) {
                        Map<String, Object> data = snapshot.getData();
                        String email = (String) data.get("usermail");
                        String downloadUrl = (String) data.get("downloadurl");
                        String id = (String) data.get("id");
                        Question post = new Question(email, downloadUrl, id);
                        solutionListe.add(post);

                    }

                    SolutionPostAdapter.notifyDataSetChanged();
                }
            }
        });
    }


    public void addSolution(View view)
    {

        Intent intentToUploadSolition = new Intent(SolutionListActivity.this, UploadSolutionActivity.class);
        intentToUploadSolition.putExtra("id", questionid);
        startActivity(intentToUploadSolition);
    }
    public void backButtonClicked(View view){
        Intent intentToQuestionList = new Intent(SolutionListActivity.this, MainActivity.class);
        startActivity(intentToQuestionList);
    }
}
