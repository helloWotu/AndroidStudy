package com.example.wisdombeijing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private int[] imageIds = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private ArrayList<ImageView> imgLists = new ArrayList<>();
    ViewPager guideViewpager;
    Button next_pageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initImages();
        guideViewpager = (ViewPager)findViewById(R.id.guide_viewPager);
        guideViewpager.setAdapter(new guideAdapter());


        next_pageBtn = (Button)findViewById(R.id.next_page);

        next_pageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
                String key = "is_first_enter";
                sp.edit().putBoolean(key,false).commit();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        guideViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                // 当页面滑动过程中的回调
            }

            @Override
            public void onPageSelected(int i) {
                // 某个页面被选中
                if (i == imageIds.length-1) {
                    next_pageBtn.setVisibility(View.VISIBLE);
                }else  {
                    next_pageBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                // 页面状态发生变化的回调
            }
        });


    }

    class guideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView view = imgLists.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    private void initImages() {
        for (int i=0;i<imageIds.length;i++) {
            ImageView img = new ImageView(this);
//            img.setImageResource(imageIds[i]);
            img.setBackgroundResource(imageIds[i]);
            imgLists.add(img);
        }

    }
}
