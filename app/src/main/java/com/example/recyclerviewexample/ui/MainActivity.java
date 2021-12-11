package com.example.recyclerviewexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.databinding.ActivityMainBinding;
import com.example.recyclerviewexample.model.MovieModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MovieViewModel movieViewModel;
    MovieAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new MovieAdapter();
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewModel.getMovies();
            }
        });

        movieViewModel.mutableLiveData.observe(this, new Observer<ArrayList<MovieModel>>() {
            @Override
            public void onChanged(ArrayList<MovieModel> movieModels) {
                //set array to adapter
                adapter.setArrayOfMovies(movieModels);

            }
        });


    }
}