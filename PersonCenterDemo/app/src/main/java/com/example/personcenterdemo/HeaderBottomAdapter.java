package com.example.personcenterdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HeaderBottomAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> implements View.OnClickListener{

    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;

    private LayoutInflater mlayoutInflater;
    private Context context;
    private List<Info> infoList;
    private int mHeaderCount=1;
    private int mBottomCount=0;

    /**
     * 构造方法
     */
    public HeaderBottomAdapter(Context context ,List<Info> dataList) {
        this.context = context;
        this.infoList = dataList;
        mlayoutInflater = LayoutInflater.from(context);
    }

    public int getContentItemCount() {
        return infoList.size();
    }

    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }

    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;
        }else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
            return ITEM_TYPE_BOTTOM;
        }else {
            return ITEM_TYPE_CONTENT;
        }
    }

    //内容ViewHolder
    public  class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView contentText;
        public ContentViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item_title);
            contentText = (TextView)itemView.findViewById(R.id.item_content);
        }

    }

    //头部ViewHolder
    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.cv_header_imageView);
        }
    }

    //尾部ViewHolder
    public class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * 声明点击接口的变量，然后实现set方法
     */
    private OnItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    /**
     * 定义点击接口
     */
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public static interface HeadImageViewClick {
        void headImageViewClick();
    }

    /**
     * 将点击事件转移给外面的调用者：
     */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mlayoutInflater.inflate(R.layout.rv_header,viewGroup,false));
        }else if (viewType == ITEM_TYPE_CONTENT) {
            View view =  mlayoutInflater.inflate(R.layout.info_item,viewGroup,false);
            /**
             * 在onCreateViewHolder()中为每个item添加点击事件
             */
            view.setOnClickListener(this);
            return new ContentViewHolder(view);
        }else if (viewType == ITEM_TYPE_BOTTOM) {
            return new BottomViewHolder(mlayoutInflater.inflate(R.layout.rv_footer,viewGroup,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ContentViewHolder) {
            Info info = infoList.get(position - mHeaderCount);
            ((ContentViewHolder)viewHolder).textView.setText(info.getTitle());
            ((ContentViewHolder)viewHolder).contentText.setText(info.getContent());
            /**
             * 上面调用接口的onItemClick()中的v.getTag()方法，这需要在onBindViewHolder()方法中设置和item的position
             */
            viewHolder.itemView.setTag(position);

        }else if (viewHolder instanceof HeaderViewHolder) {

            final ImageView imageView = ((HeaderViewHolder)viewHolder).imageView;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("headImageViewClick", "onClick: ");



                }
            });

        }else if (viewHolder instanceof BottomViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }


    public void updateData(List<Info> list) {
        this.infoList = list;
        notifyDataSetChanged();
    }

    /**
     * 显示头像选择
     */
    private void showTypeDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder()


    }

}
