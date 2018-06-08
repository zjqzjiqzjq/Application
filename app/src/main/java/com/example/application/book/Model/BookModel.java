package com.example.application.book.Model;

import com.example.application.bean.BookBean;
import com.example.application.http.Api;
import com.example.application.http.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/6/8.
 */

public class BookModel implements IBookModel{
    @Override
    public void loadBook(final String name,final int id,final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.Book_HOST);
        //enqueue异步请求
        retrofitHelper.getBook(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<BookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(BookBean bookBean) {
                        iOnLoadListener.success(bookBean);
                    }
                });
    }
}
