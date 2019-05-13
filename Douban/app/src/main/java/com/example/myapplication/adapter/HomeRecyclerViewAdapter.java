package com.example.myapplication.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.MovieData;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.Myholder> {

    private List<Object> mList;
    private LayoutInflater mLayoutInflater;
    private String[] mTitles;
    private Context mContext;

    public HomeRecyclerViewAdapter(Context context,List<Object> list,String[] titles) {
        mContext = context;
        mList = list;
        mTitles = titles.clone();
        mLayoutInflater = mLayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mLayoutInflater.inflate(R.layout.mene_movie, viewGroup, false);
        Myholder myholder = new Myholder(view);

        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int i) {
        myholder.tvTitile.setText(mTitles[i]);

        MovieData movieData = (MovieData)mList.get(i);

        myholder.tvMovieNameOne.setText(movieData.getSubjects().get(0).getTitle());
        Glide.with(mContext).load(movieData.getSubjects().get(0).getImages().getLarge()).into(myholder.imMovieOne);


        myholder.tvMovieNameTwo.setText(movieData.getSubjects().get(1).getTitle());
        Glide.with(mContext).load(movieData.getSubjects().get(1).getImages().getLarge()).into(myholder.imMovieTwo);

        myholder.tvMovieNameThree.setText(movieData.getSubjects().get(2).getTitle());
        Glide.with(mContext).load(movieData.getSubjects().get(2).getImages().getLarge()).into(myholder.imMovieThree);
    }


    public class MyclickListenr implements View.OnClickListener {
        int position;

        public MyclickListenr(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.load_more:

                    break;
                    default:break;
            }
        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class Myholder extends RecyclerView.ViewHolder {

        RelativeLayout mRelativeLayout;
        TextView tvTitile;
        TextView tvMovieNameOne;
        TextView tvMovieNameTwo;
        TextView tvMovieNameThree;

        ImageView imMovieOne;
        ImageView imMovieTwo;
        ImageView imMovieThree;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.load_more);

            tvTitile = (TextView) itemView.findViewById(R.id.menu_title);

            tvMovieNameOne = (TextView) itemView.findViewById(R.id.menu_movie_name_one);
            tvMovieNameTwo = (TextView) itemView.findViewById(R.id.menu_movie_name_two);
            tvMovieNameThree = (TextView) itemView.findViewById(R.id.menu_movie_name_three);

            imMovieOne = (ImageView) itemView.findViewById(R.id.menu_image_pic_one);
            imMovieTwo = (ImageView) itemView.findViewById(R.id.menu_image_pic_two);
            imMovieThree = (ImageView) itemView.findViewById(R.id.menu_image_pic_three);
        }
    }
}
