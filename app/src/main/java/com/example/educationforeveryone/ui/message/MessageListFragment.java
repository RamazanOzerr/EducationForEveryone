package com.example.educationforeveryone.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.educationforeveryone.databinding.FragmentMessageListBinding;
import com.example.educationforeveryone.ui.PrivateChat.PrivateChatActivity;

public class MessageListFragment extends Fragment {

    private FragmentMessageListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MessageViewModel notificationsViewModel =
                new ViewModelProvider(this).get(MessageViewModel.class);

        binding = FragmentMessageListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.textDemo.setOnClickListener(view -> {
            getActivity().startActivity(new Intent(getContext(), PrivateChatActivity.class));
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}