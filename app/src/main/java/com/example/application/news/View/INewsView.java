package com.example.application.news.View;


import com.example.application.bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsView {
    void hideDialog();
    void showNews(NewsBean newsBean);
    void showErrorMsg(String error);
    void showDialog();
}
