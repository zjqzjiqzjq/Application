package com.example.application.book;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.application.ADetailActivity;
import com.example.application.R;
import com.example.application.bean.BookBean;
import com.example.application.book.Presenter.BookPresenter;
import com.example.application.book.View.IBookView;
import com.example.application.http.Api;


public class BookFragment extends Fragment implements IBookView{

    private BookPresenter bookPresenter;
    private Context context;
    private int book_id1=1;
    private int book_id2=2;
    private int book_id3=3;
    private int book_id4=4;

    //private ItemBookAdapter bookAdapter;
    //private RecyclerView rv_book;
    //private SwipeRefreshLayout srl_book;
    private ImageView iv_book1;
    private TextView tv_book_title1;
    private TextView tv_book_author1;
    private TextView tv_book_subtitle1;
    private TextView tv_book_rating1;
    private TextView tv_book_publisher1;
    private LinearLayout ll_book1;
    private RelativeLayout rl_look1;
    private CardView cv_book1;
    private ImageView iv_book2;
    private TextView tv_book_title2;
    private TextView tv_book_author2;
    private TextView tv_book_subtitle2;
    private TextView tv_book_rating2;
    private TextView tv_book_publisher2;
    private LinearLayout ll_book2;
    private RelativeLayout rl_look2;
    private CardView cv_book2;
    private ImageView iv_book3;
    private TextView tv_book_title3;
    private TextView tv_book_author3;
    private TextView tv_book_subtitle3;
    private TextView tv_book_rating3;
    private TextView tv_book_publisher3;
    private LinearLayout ll_book3;
    private RelativeLayout rl_look3;
    private CardView cv_book3;
    private ImageView iv_book4;
    private TextView tv_book_title4;
    private TextView tv_book_author4;
    private TextView tv_book_subtitle4;
    private TextView tv_book_rating4;
    private TextView tv_book_publisher4;
    private LinearLayout ll_book4;
    private RelativeLayout rl_look4;
    private CardView cv_book4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookPresenter = new BookPresenter(this);
        //srl_book = view.findViewById(R.id.srl_book);
        //rv_book = view.findViewById(R.id.rv_book);
        rl_look1 = (RelativeLayout) view.findViewById(R.id.rl_look1);
        rl_look2 = (RelativeLayout) view.findViewById(R.id.rl_look2);
        rl_look3 = (RelativeLayout) view.findViewById(R.id.rl_look3);
        rl_look4 = (RelativeLayout) view.findViewById(R.id.rl_look4);
        iv_book1 = (ImageView) view.findViewById(R.id.iv_book1);
        iv_book2 = (ImageView) view.findViewById(R.id.iv_book2);
        iv_book3 = (ImageView) view.findViewById(R.id.iv_book3);
        iv_book4 = (ImageView) view.findViewById(R.id.iv_book4);
        ll_book1 = (LinearLayout) view.findViewById(R.id.ll_book1);
        ll_book2 = (LinearLayout) view.findViewById(R.id.ll_book2);
        ll_book3 = (LinearLayout) view.findViewById(R.id.ll_book3);
        ll_book4 = (LinearLayout) view.findViewById(R.id.ll_book4);
        tv_book_title1 = (TextView) view.findViewById(R.id.tv_book_title1);
        tv_book_title2 = (TextView) view.findViewById(R.id.tv_book_title2);
        tv_book_title3 = (TextView) view.findViewById(R.id.tv_book_title3);
        tv_book_title4 = (TextView) view.findViewById(R.id.tv_book_title4);
        tv_book_author1 = (TextView) view.findViewById(R.id.tv_book_author1);
        tv_book_author2 = (TextView) view.findViewById(R.id.tv_book_author2);
        tv_book_author3 = (TextView) view.findViewById(R.id.tv_book_author3);
        tv_book_author4 = (TextView) view.findViewById(R.id.tv_book_author4);
        tv_book_subtitle2 = (TextView) view.findViewById(R.id.tv_book_subtitle2);
        tv_book_subtitle1 = (TextView) view.findViewById(R.id.tv_book_subtitle1);
        tv_book_subtitle3 = (TextView) view.findViewById(R.id.tv_book_subtitle3);
        tv_book_subtitle4 = (TextView) view.findViewById(R.id.tv_book_subtitle4);
        tv_book_rating1 = (TextView) view.findViewById(R.id.tv_book_rating1);
        tv_book_rating2 = (TextView) view.findViewById(R.id.tv_book_rating2);
        tv_book_rating3 = (TextView) view.findViewById(R.id.tv_book_rating3);
        tv_book_rating4 = (TextView) view.findViewById(R.id.tv_book_rating4);
        tv_book_publisher1 = (TextView) view.findViewById(R.id.tv_book_publisher1);
        tv_book_publisher2 = (TextView) view.findViewById(R.id.tv_book_publisher2);
        tv_book_publisher3 = (TextView) view.findViewById(R.id.tv_book_publisher3);
        tv_book_publisher4 = (TextView) view.findViewById(R.id.tv_book_publisher4);
        cv_book1 = (CardView) view.findViewById(R.id.cv_book1);
        cv_book2 = (CardView) view.findViewById(R.id.cv_book2);
        cv_book3 = (CardView) view.findViewById(R.id.cv_book3);
        cv_book4 = (CardView) view.findViewById(R.id.cv_book4);


        //bookAdapter = new ItemBookAdapter(getActivity());
        //srl_book.setColorSchemeColors(Color.parseColor("#ffce3d3a"));


        bookPresenter.loadBook(Api.FIRST_NAME,book_id1);
        bookPresenter.loadBook(Api.SECOND_NAME,book_id2);
        bookPresenter.loadBook(Api.THIRD_NAME,book_id3);
        bookPresenter.loadBook(Api.FOURTH_NAME,book_id4);

        /*srl_book.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bookPresenter.loadBook(Api.FIRST_NAME);
                bookPresenter.loadBook(Api.SECOND_NAME);
                bookPresenter.loadBook(Api.THIRD_NAME);
                bookPresenter.loadBook(Api.FOURTH_NAME);
            }
        });*/

    }

    @Override
    public void hideDialog() {
        //srl_book.setRefreshing(false);
    }

    @Override
    public void showBook(final BookBean.BooksBean bean) {
        /*bookAdapter.setData(bookBean.getBooks());
        rv_book.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_book.setAdapter(bookAdapter);
        rv_book.setHorizontalScrollBarEnabled(true);
        rv_book.setAdapter(bookAdapter);*/
        if (bean == null) {
            return;
        }


        Glide.with(context)
                .load(bean.getImages().getSmall())
                .into(iv_book1);

        tv_book_title1.setText(bean.getTitle());

        tv_book_author1.setText("作者：" + bean.getAuthor().get(0));

        tv_book_subtitle1.setText(bean.getSubtitle());

        tv_book_publisher1.setText("出版社：" + bean.getPublisher());

        cv_book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ADetailActivity.class);
                intent.putExtra("url", bean.getAlt());
                intent.putExtra("title", bean.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void showErrorMsg(String error) {
        Toast.makeText(getContext(),"加载失败" + error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        //srl_book.setRefreshing(true);
    }
}
