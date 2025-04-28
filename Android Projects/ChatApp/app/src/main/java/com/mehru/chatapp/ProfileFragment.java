package com.mehru.chatapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.mehru.chatapp.Utils.FirebaseUtils;
import com.mehru.chatapp.model.UserModel;


public class ProfileFragment extends Fragment {

    ImageView profilePic;
    EditText profileUserNameInput;
    EditText profileUserPhoneInput;
    AppCompatButton updateBtn;
    TextView logoutBtn;
    ProgressBar progressBar ;

    UserModel currentUsrModel;

    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profilePic = view.findViewById(R.id.profile_photo);
        profileUserNameInput =view.findViewById(R.id.profile_userName);
        profileUserPhoneInput =view.findViewById(R.id.profile_PhoneNo);
        updateBtn = view.findViewById(R.id.profile_update_btn);
        progressBar = view.findViewById(R.id.profile_progressbar);
        logoutBtn = view.findViewById(R.id.logout_btn);
        getUserData();

        updateBtn.setOnClickListener(v -> {
            updateBtnClick();
        });

        logoutBtn.setOnClickListener(v -> {
            FirebaseUtils.logout();
            Intent intent = new Intent(getContext(), Splash_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        return view;


    }

    void updateBtnClick(){
        String newUsrName = profileUserNameInput.getText().toString();
        if (newUsrName.isEmpty() || newUsrName.length()<3){
            profileUserPhoneInput.setError("Usr Name Length Should At least 3 chars ");
            return;
        }
        currentUsrModel.setUserName(newUsrName);
        setInProgress(true);
        updateToFireStore();
    }

    void updateToFireStore(){
        FirebaseUtils.currentUserDetails().set(currentUsrModel)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                setInProgress(false);
                if (task.isSuccessful()){
                    Toast.makeText(getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void getUserData(){
        setInProgress(true);
        FirebaseUtils.currentUserDetails().get().addOnCompleteListener(task -> {
            setInProgress(false);
            currentUsrModel=task.getResult().toObject(UserModel.class);
            profileUserNameInput.setText(currentUsrModel.getUserName());
            profileUserPhoneInput.setText(currentUsrModel.getPhoneNumber());
        });
    }



    void setInProgress(boolean inProgress){
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            updateBtn.setVisibility(View.GONE);
        }else {

        }progressBar.setVisibility(View.GONE);
        updateBtn.setVisibility(View.VISIBLE);


    }
}