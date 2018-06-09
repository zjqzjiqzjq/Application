package com.example.application;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.myinfo.MyinfoFragment;
import com.example.application.news.NewsFragment;
import com.example.application.utils.AnalyslsUtils;
import com.example.application.book.BookFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout main_body;
    private TextView bottom_bar_text_news;
    private ImageView bottom_bar_image_news;
    private RelativeLayout bottom_bar_news_btn;
    private TextView bottom_bar_text_book;
    private ImageView bottom_bar_image_book;
    private RelativeLayout bottom_bar_book_btn;
    private TextView bottom_bar_text_myinfo;
    private ImageView bottom_bar_image_myinfo;
    private RelativeLayout bottom_bar_myinfo_btn;
    private LinearLayout main_bottom_bar;
    protected long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        setMain();
    }

    private void setMain() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_body,new NewsFragment()).commit();
        setSelectStatus(0);
    }

    private void initView() {
        main_body = (RelativeLayout) findViewById(R.id.main_body);
        bottom_bar_text_news = (TextView) findViewById(R.id.bottom_bar_text_news);
        bottom_bar_image_news = (ImageView) findViewById(R.id.bottom_bar_image_news);
        bottom_bar_news_btn = (RelativeLayout) findViewById(R.id.bottom_bar_news_btn);
        bottom_bar_text_book = (TextView) findViewById(R.id.bottom_bar_text_book);
        bottom_bar_image_book = (ImageView) findViewById(R.id.bottom_bar_image_book);
        bottom_bar_book_btn = (RelativeLayout) findViewById(R.id.bottom_bar_book_btn);
        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
        bottom_bar_myinfo_btn = (RelativeLayout) findViewById(R.id.bottom_bar_myinfo_btn);
        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);

        bottom_bar_news_btn.setOnClickListener(this);
        bottom_bar_book_btn.setOnClickListener(this);
        bottom_bar_myinfo_btn.setOnClickListener(this);
    }

    private void setSelectStatus(int index) {
        switch (index){
            case 0:
                bottom_bar_image_news.setImageResource(R.drawable.main_news_icon_selected);
                bottom_bar_text_news.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_book.setImageResource(R.drawable.main_book_icon);
                bottom_bar_text_book.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));
                break;
            case 1:
                bottom_bar_image_book.setImageResource(R.drawable.main_book_icon_selected);
                bottom_bar_text_book.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_news.setImageResource(R.drawable.main_news_icon);
                bottom_bar_text_news.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));
                break;
            case 2:
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon_selected);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_news.setImageResource(R.drawable.main_news_icon);
                bottom_bar_text_news.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_book.setImageResource(R.drawable.main_book_icon);
                bottom_bar_text_book.setTextColor(Color.parseColor("#666666"));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bottom_bar_news_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new NewsFragment()).commit();
                setSelectStatus(0);
                break;
            case R.id.bottom_bar_book_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new BookFragment()).commit();
                setSelectStatus(1);
                break;
            case R.id.bottom_bar_myinfo_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new MyinfoFragment()).commit();
                setSelectStatus(2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            boolean isLogin = data.getBooleanExtra("isLogin",false);
            if (isLogin){
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new NewsFragment()).commit();
                setSelectStatus(0);
            }else {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new MyinfoFragment()).commit();
                setSelectStatus(2);
            }
        }
        if(requestCode==000){
            this.getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new BookFragment()).commit();
            setSelectStatus(1);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(MainActivity.this,"再按一次退出应用",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                this.finish();
                if (AnalyslsUtils.readLoginStatus(this)){
                    AnalyslsUtils.cleanLoginStatus(this);
                }
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
