package com.example.application.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import com.example.application.MyFragmentAdapter;
import com.example.application.R;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment  {

    public static final int NEWS_TYPE_TOP = 0;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentTitles = new ArrayList<>();
    private TabLayout tl_news;
    private ViewPager vp_news;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tl_news = (TabLayout) view.findViewById(R.id.tl_news);
        vp_news = (ViewPager) view.findViewById(R.id.vp_news);
        setViewPager();
        //预加载界面数
        vp_news.setOffscreenPageLimit(2);
        tl_news.setupWithViewPager(vp_news);
    }

    private void setViewPager() {
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_TOP));
        fragmentTitles.add("头条");
        MyFragmentAdapter adapter = new MyFragmentAdapter(getChildFragmentManager(),fragments,fragmentTitles);
        vp_news.setAdapter(adapter);
    }
}
