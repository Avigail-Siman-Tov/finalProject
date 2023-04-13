package com.finalproject.finalproject.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.finalproject.finalproject.LoginActivity;
import com.finalproject.finalproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(LogoutActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
//
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(runnable,5000);
    }
}