package com.example.educationforeveryone.ui.Profile;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.educationforeveryone.R;
import com.example.educationforeveryone.databinding.FragmentHomeBinding;
import com.example.educationforeveryone.databinding.FragmentProfileBinding;
import com.example.educationforeveryone.ui.Home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileFragmentViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(ProfileFragmentViewModel.class);

        viewModel.getData().observe(getViewLifecycleOwner(), new Observer<ProfileModel>() {
            @Override
            public void onChanged(ProfileModel profileModel) {
                updateData(profileModel);
            }
        });

        setListeners();

        return root;
    }

    private void setListeners() {
        binding.buttonLogout.setOnClickListener(view -> {
            //todo: log out
        } );

        binding.buttonSave.setOnClickListener(view -> {
            //todo: save info
        });
    }

    private void updateData(ProfileModel profileModel){
        binding.textUsername.setText(profileModel.getUsername());
        binding.textBio.setText(profileModel.getBio());
        StringBuilder temp = new StringBuilder();
        for(String str : profileModel.getSkills()){
            temp.append(str).append(", ");
        }
        binding.textSkills.setText(temp);
    }



}