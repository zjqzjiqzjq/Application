package com.example.application.http;

import com.example.application.bean.BookBean;
import com.example.application.bean.NewsBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                                 @Path("id") String id,
                                 @Path("startPage") int startPage);

    @GET("/v2/book/search")
    Observable<BookBean> getBook(@Query("q") String name
                                 /*@Query("fields") String what*/);
}
