package com.example.educationforeveryone.ui.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationforeveryone.databinding.QuestionPostRecyclerRowBinding;
import com.example.educationforeveryone.ui.Post.Question;
import com.example.educationforeveryone.ui.Solution.SolutionListActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuestionPostAdapter extends RecyclerView.Adapter<QuestionPostAdapter.PostHolder> {

    private ArrayList<Question> questionListe;

    // Yeni bir View Holder oluşturmak için çağrılan metot
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout dosyasından bir görünüm oluşturuluyor
        QuestionPostRecyclerRowBinding recyclerRowBinding = QuestionPostRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        // Yeni bir ViewHolder nesnesi oluşturulup geri döndürülüyor
        return new PostHolder(recyclerRowBinding);
    }

    // Veri kümesindeki öğe sayısını döndürür
    @Override
    public int getItemCount() {
        return questionListe.size();
    }

    // Constructor metodu
    public QuestionPostAdapter(ArrayList<Question> liste) {
        this.questionListe = liste;
    }

    // Görünümde belirtilen konuma verileri bağlar
    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, @SuppressLint("RecyclerView") int position) {
        // Görünüme öğeleri yerleştirme işlemleri yapılır
        holder.imagePostRecyclerRowBinding.recyclerViewUserEmailText.setText(questionListe.get(position).mail);
        Picasso.get().load(questionListe.get(position).downloadUrl).into(holder.imagePostRecyclerRowBinding.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToSolution = new Intent(holder.itemView.getContext(), SolutionListActivity.class);
                intentToSolution.putExtra("id",questionListe.get(position).id);
                holder.itemView.getContext().startActivity(intentToSolution);
            }
        });
    }

    // ViewHolder sınıfı tanımlanır
    class PostHolder extends RecyclerView.ViewHolder {
        // Layout dosyasındaki bileşenlere erişmek için gerekli olan ImagePostRecyclerRowBinding nesnesi oluşturulur
        QuestionPostRecyclerRowBinding imagePostRecyclerRowBinding;

        // Yapıcı metot
        public PostHolder(QuestionPostRecyclerRowBinding imagePostRecyclerRowBinding) {
            super(imagePostRecyclerRowBinding.getRoot());
            this.imagePostRecyclerRowBinding = imagePostRecyclerRowBinding;
        }
    }
}