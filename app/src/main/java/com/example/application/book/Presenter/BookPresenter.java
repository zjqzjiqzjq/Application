package com.example.application.book.Presenter;

import com.example.application.bean.BookBean;
import com.example.application.book.Model.BookModel;
import com.example.application.book.Model.IBookModel;
import com.example.application.book.Model.IOnLoadListener;
import com.example.application.book.View.IBookView;

/**
 * Created by lenovo on 2018/6/8.
 */

public class BookPresenter implements IBookPresenter,IOnLoadListener {
    private IBookModel iBookModel;
    private IBookView iBookView;

    public BookPresenter(IBookView iBookView) {
        this.iBookView = iBookView;
        this.iBookModel = new BookModel();
    }
    @Override
    public void loadBook(String name) {
        iBookView.showDialog();
        iBookModel.loadBook(name,this);
    }

    @Override
    public void fail(String error) {
        iBookView.hideDialog();
        iBookView.showErrorMsg(error);
    }

    @Override
    public void success(BookBean bookBean) {
        iBookView.hideDialog();
        if (bookBean != null){
            iBookView.showBook(bookBean);
        }
    }
}
