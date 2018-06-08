package com.example.application.book.Model;

import com.example.application.bean.BookBean;

/**
 * Created by lenovo on 2018/6/8.
 */

public interface IOnLoadListener {
    void fail(String error);
    void success(BookBean bookBean);
}
