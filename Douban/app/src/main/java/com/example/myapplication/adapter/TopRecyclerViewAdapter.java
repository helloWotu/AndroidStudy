package com.example.myapplication.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.MovieData;


public class TopRecyclerViewAdapter extends RecyclerView.Adapter<TopRecyclerViewAdapter.Myholder> {

    private MovieData mMovieData;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public TopRecyclerViewAdapter(Context context, MovieData movieData) {
        mMovieData = movieData;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.menu_top, viewGroup, false);
        Myholder myholder = new Myholder(view);

        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int i) {

        myholder.mTextView.setText(mMovieData.getSubjects().get(i).getTitle());
        Glide.with(mContext).load(mMovieData.getSubjects().get(i).getImages().getLarge()).into(myholder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mMovieData.getSubjects().size();
    }

    static public class Myholder extends RecyclerView.ViewHolder {

        CardView mCardView;
        TextView mTextView;
        ImageView mImageView;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            mCardView = (CardView)itemView.findViewById(R.id.top_cardView);
            mTextView = (TextView) itemView.findViewById(R.id.top_cardView_textview);
            mImageView = (ImageView) itemView.findViewById(R.id.top_cardView_imageview);
        }


    }
}
