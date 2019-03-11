package com.example.personcenterdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class PersonCenterAdapter extends RecyclerView.Adapter<PersonCenterAdapter.ViewHolder> {

    private List<Info> personInfoList;
    private Context context;

    public PersonCenterAdapter(Context context,List<Info> list) {
        this.context = context;
        this.personInfoList = list;
    }//初始化时注入数据


    public void update(List<Info> list) {
        this.personInfoList = list;
//        notifyDataSetChanged();
    }

    /**
     * 解析布局，并注入到viewHolder
     * @return 给下一步提供一个ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_item,viewGroup,false);
        return new ViewHolder(view);
    }

    /**
     * 操作item的地方
     * @param viewHoder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHoder, int i) {
        Info info = personInfoList.get(i);
        viewHoder.titleText.setText(info.getTitle());
        viewHoder.contentText.setText(info.getContent());
        //对整个item监听
        viewHoder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return personInfoList.size();
    }



    //初始化控件的viewHolder
     class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;
        EditText contentText;

        public ViewHolder(View view) {
            super(view);
            titleText = view.findViewById(R.id.item_title);
            contentText = view.findViewById(R.id.item_content);
        }

    }

    /**
     * 定义一个接口用于外部实现RecycleView的item的操作
     */
//    public interface OnItemClickListener {
//        void onItemClick(View v, int position);
//    }



}
