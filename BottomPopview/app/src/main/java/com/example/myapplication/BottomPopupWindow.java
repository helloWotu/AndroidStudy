package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class BottomPopupWindow extends PopupWindow implements View.OnClickListener {

    private Activity mContext;
    private View conentView;
    private Button btn_close;
    private RecyclerView mRecyclerView;
    private DividerItemDecoration mDivider;
    private String[] mStrings = {"0.5","0.75","1","1.25","1.5","1.75","2"};
    private int windowHeight;
    MyAdapter mAdapter;

    public BottomPopupWindow(final Activity context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popu_window,null);

        Point point = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        windowHeight = height;

        setContentView(conentView);

        setWidth(width);
        setHeight(DensityUtil.dip2px(384,context));

        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.pop_up_anim);
        update();

        initPopupWindowView();
        initListener();

    }

    @Override
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        if (isShowing()) {
            WindowManager.LayoutParams lp = mContext.getWindow().getAttributes();
            lp.alpha = 0.4f;
            mContext.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            mContext.getWindow().setAttributes(lp);
        }
    }

    public void showPopupWindow(View parent) {
        if (!isShowing()) {
            showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);
        }else {
            dismiss();
        }
    }

    private void initListener() {
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });
    }

    private void initPopupWindowView() {

        btn_close = (Button) conentView.findViewById(R.id.pop_close_btn);
        mRecyclerView = (RecyclerView) conentView.findViewById(R.id.pop_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        //添加分割线
        mDivider = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDivider);

        //获取数据并设置数据
        mAdapter = new MyAdapter(mContext,mStrings);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickLitener(new MyAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position, String s) {
                Toast.makeText(mContext,"点击了" + position,Toast.LENGTH_SHORT).show();
                mAdapter.setPosition(position);
                mAdapter.notifyDataSetChanged();
                dismiss();
            }
        });


    }






    @Override
    public void onClick(View v) {

    }
}
