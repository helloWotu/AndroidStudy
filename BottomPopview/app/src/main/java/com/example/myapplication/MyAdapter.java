package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    private String[] mData;
    private Context adapterContext;
    private LayoutInflater mLayoutInflater;
    private int mPosition = 3;
    private OnItemClickLitener mOnItemClickLitener;

    public MyAdapter(Context context ,String[] data) {
        mData = data.clone();
        adapterContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        mOnItemClickLitener = onItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position, String s);
    }

    public void setSelection(int position){
        this.mPosition = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.popview_item,viewGroup,false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder myholder, int i) {
        myholder.mPopTitleView.setText(mData[i] + "x");

        if (i == mPosition) {
            myholder.mPopImageView.setBackgroundColor(Color.parseColor("#008577"));
        }else {
            myholder.mPopImageView.setBackgroundColor(Color.parseColor("#D81B60"));
        }

        if (mOnItemClickLitener != null) {

            myholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(myholder.itemView,myholder.getAdapterPosition(),mData[myholder.getAdapterPosition()]);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class Myholder extends RecyclerView.ViewHolder {

        TextView mPopTitleView;
        ImageView mPopImageView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            mPopTitleView = itemView.findViewById(R.id.pop_title);
            mPopImageView = itemView.findViewById(R.id.pop_image_view);
        }
    }
}