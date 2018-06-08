package com.example.application.book.View;

import com.example.application.bean.BookBean;

/**
 * Created by lenovo on 2018/6/8.
 */

public interface IBookView {
    void hideDialog();
    void showBook(BookBean bookBean);
    void showErrorMsg(String error);
    void showDialog();
}
