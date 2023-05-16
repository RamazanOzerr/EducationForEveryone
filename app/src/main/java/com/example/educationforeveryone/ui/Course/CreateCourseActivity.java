package com.example.educationforeveryone.ui.Course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.educationforeveryone.MainActivity;
import com.example.educationforeveryone.databinding.ActivityCreateCourseBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class CreateCourseActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;
    private ActivityCreateCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateCourseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


    }

    public void creatButton(View view){
        String lesson = binding.lessonText.getText().toString();
        String year = binding.yearText.getText().toString();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();

        HashMap<String, Object> courseData = new HashMap<>();
        courseData.put("lesson", lesson);
        courseData.put("year", year);
        courseData.put("usermail", email);
        courseData.put("date", FieldValue.serverTimestamp());
        firebaseFirestore.collection("coursePost").add(courseData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Intent intent = new Intent(CreateCourseActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateCourseActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }



}