package com.example.recyclerviewexample.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.model.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    ArrayList<MovieModel> arrayList = new ArrayList<>();
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.movieName.setText(arrayList.get(position).getMovieName());
        holder.movieDescription.setText(arrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public void setArrayOfMovies(ArrayList<MovieModel> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieName,movieDescription;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieName = (TextView) itemView.findViewById(R.id.textViewMovieName);
            movieDescription = (TextView) itemView.findViewById(R.id.textViewMovieDescription);

        }
    }
}
