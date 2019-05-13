package com.example.myapplication.view.top250;

import android.graphics.Rect;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapter.TopRecyclerViewAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.bean.MovieData;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Topfragment extends BaseFragment<TopPresenter> implements ITopView {

    private final int PAGE_SIZE = 20;
    private int pageCount = 0;

    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;

    @Override
    public void initData() {
        presenter.requestTopData(pageCount*PAGE_SIZE,PAGE_SIZE,false);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_top, null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.hot_recyclerView);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000/*,false*/);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000/*,false*/);
            }
        });

        return view;
    }

    @Override
    protected TopPresenter createPresenter() {
        return new TopPresenter(this);
    }

    @Override
    public void getDataSuccess(MovieData movieData,boolean isLoadMore) {
        int spaceCount = 3;
        int spacing = 40;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, spaceCount);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spaceCount,spacing,true));
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        TopRecyclerViewAdapter topRecyclerViewAdapter = new TopRecyclerViewAdapter(mActivity,movieData);
        mRecyclerView.setAdapter(topRecyclerViewAdapter);

    }



    @Override
    public void getDataError(String msg) {

    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration  {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int colum = position % spanCount;
            if (includeEdge) {
                outRect.left = spacing-colum*spacing / spanCount;
                outRect.right = (colum + 1)*spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }else  {
                outRect.left = colum*spacing/spanCount;
                outRect.right = spacing - (colum + 1)*spacing/spanCount;
            }
            if (position >= spanCount) {
                outRect.top = spacing;
            }

        }
    }


}
