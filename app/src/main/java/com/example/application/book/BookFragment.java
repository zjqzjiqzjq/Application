package com.example.application.book;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.application.ADetailActivity;
import com.example.application.R;
import com.example.application.bean.BookBean;
import com.example.application.book.Presenter.BookPresenter;
import com.example.application.book.View.IBookView;
import com.example.application.http.Api;

import static android.widget.Toast.LENGTH_SHORT;


public class BookFragment extends Fragment implements IBookView, View.OnClickListener {

    private BookPresenter bookPresenter;
    private ItemBookAdapter bookAdapter;
    private String bookName;
    private int bookid;
    private RecyclerView rv_book;
    private SwipeRefreshLayout srl_book;
    private EditText et_find_book;
    private RelativeLayout rl_book;
    private Button btn_find_book;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookPresenter = new BookPresenter(this);
        srl_book = view.findViewById(R.id.srl_book);
        rv_book = view.findViewById(R.id.rv_book);
        et_find_book = view.findViewById(R.id.et_find_book);
        rl_book = view.findViewById(R.id.rl_book);
        btn_find_book = view.findViewById(R.id.btn_find_book);

        bookAdapter = new ItemBookAdapter(getActivity());
        srl_book.setColorSchemeColors(Color.parseColor("#ffce3d3a"));

        bookPresenter.loadBook(Api.Book_NAME);

        srl_book.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bookPresenter.loadBook(Api.Book_NAME);
            }
        });

        btn_find_book.setOnClickListener(this);

    }

    @Override
    public void hideDialog() {
        srl_book.setRefreshing(false);
    }

    @Override
    public void showBook(BookBean bookBean) {
        bookAdapter.setData(bookBean.getBooks());
        rv_book.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_book.setAdapter(bookAdapter);
        rv_book.setHorizontalScrollBarEnabled(true);
        rv_book.setAdapter(bookAdapter);
    }

    @Override
    public void showErrorMsg(String error) {
        Toast.makeText(getContext(), "加载失败" + error, LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        srl_book.setRefreshing(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_find_book:
                bookName = et_find_book.getText().toString().trim();
                if (TextUtils.isEmpty(bookName)){
                    Toast.makeText(getActivity(),"请输入书名", LENGTH_SHORT).show();
                }else {
                    bookPresenter.loadBook(bookName);
                }
                break;
        }

    }
}
