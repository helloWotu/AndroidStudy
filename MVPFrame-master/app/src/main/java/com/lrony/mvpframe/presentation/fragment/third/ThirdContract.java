package com.lrony.mvpframe.presentation.fragment.third;

import android.support.annotation.NonNull;

import com.lrony.mvpframe.mvp.MvpPresenter;
import com.lrony.mvpframe.mvp.MvpView;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Lrony on 18-4-10.
 */
public interface ThirdContract {

    interface View extends MvpView {

        void setTabContent(@NonNull SupportFragment[] fragments, @NonNull String[] titles);
    }

    interface Presenter extends MvpPresenter<View> {

        void loadData();
    }
}
