package com.example.educationforeveryone.ui.Chats;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class ChatRepository {

    DatabaseReference reference, reference2;
    private MutableLiveData<List<ChatModel>> liveData;
    private List<ChatModel> chatModelList;
    FirebaseUser user;
    private List<String> userKeyList;

    public ChatRepository(){
        chatModelList = new ArrayList<>();
        liveData = new MutableLiveData<>();
//        reference = FirebaseDatabase.getInstance().getReference("Messages");
//        reference2 = FirebaseDatabase.getInstance().getReference("Users");
        user = FirebaseAuth.getInstance().getCurrentUser();
        userKeyList = new ArrayList<>();
    }

    public MutableLiveData<List<ChatModel>> getChats(){

//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    userKeyList.add(dataSnapshot.getKey());
//
////                    getUsername();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//
//        Query query = reference.child("fatih"); //todo: user.getUid()
//        query.addListenerForSingleValueEvent(valueEventListener);

        //todo: db den veri indirme kısmını yazcaz

        ChatModel chatModel = new ChatModel("Azim","fatih");
        ChatModel chatModel2 = new ChatModel("Ramazan","fatih");
        ChatModel chatModel3 = new ChatModel("Fatih terim","fatih");
        ChatModel chatModel1 = new ChatModel("üçlü priz", "fatih");

        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel3);
        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel1);
        chatModelList.add(chatModel3);
        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel3);
        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel3);
        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel3);
        chatModelList.add(chatModel);
        chatModelList.add(chatModel2);
        chatModelList.add(chatModel3);

        liveData.setValue(chatModelList);

        return liveData;
    }

//    private void getUsername(){
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//
//        Query query = reference2.child()
//    }
}
