package com.example.recyclerviewexample.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerviewexample.model.MovieModel;
import com.example.recyclerviewexample.pojo.Database;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    MutableLiveData<ArrayList<MovieModel>> mutableLiveData = new MutableLiveData<>();
    public void getMovies(){

        Database database = new Database();
        mutableLiveData.setValue(database.getAllMovies());
    }
}
