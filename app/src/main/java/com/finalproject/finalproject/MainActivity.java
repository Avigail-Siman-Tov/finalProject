package com.finalproject.finalproject;

import android.os.Bundle;

import com.finalproject.finalproject.collection.Traveler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.finalproject.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public  static Traveler traveler;

    private ActivityMainBinding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);




        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());




        BottomNavigationView navView = findViewById(R.id.nav_view);




        // Passing each menu ID as a set of Ids because each

        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration  = new AppBarConfiguration.Builder(

                R.id.navigation_home,R.id.navigation_dashboard, R.id.navigation_notifications)

                .build();







        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(binding.navView, navController);

//        ActionBar actionBar;

//        actionBar = getSupportActionBar();




        // Define ColorDrawable object and parse color

        // using parseColor method

        // with color hash code as its parameter

//        ColorDrawable colorDrawable

//                = new ColorDrawable(Color.parseColor("#FFFFFF"));

//        actionBar.setTitle(Html.fromHtml("<font color='#ff0000'>ActionBarTitle </font>"));

        // Set BackgroundDrawable

//        actionBar.setBackgroundDrawable(colorDrawable);




    }







}

