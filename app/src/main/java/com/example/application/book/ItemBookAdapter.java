package com.example.application.book;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.application.ADetailActivity;
import com.example.application.R;
import com.example.application.bean.BookBean;

import java.util.ArrayList;
import java.util.List;

public class ItemBookAdapter extends RecyclerView.Adapter<ItemBookAdapter.ViewHolder> {

    private List<BookBean.BooksBean> objects = new ArrayList<BookBean.BooksBean>();

    private Context context;

    public ItemBookAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<BookBean.BooksBean> objects) {
        this.objects = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final BookBean.BooksBean bean = objects.get(position);
        if (bean == null) {
            return;
        }

        Glide.with(context)
                .load(bean.getImages().getSmall())
                .into(holder.ivBook);

        holder.tvBookTitle.setText(bean.getTitle());
        String author="";
        for(int i=0;i<bean.getAuthor().size();i++){
            if (i==bean.getAuthor().size()-1){
                author+=bean.getAuthor().get(i);
            }else{
                author+=bean.getAuthor().get(i)+"/";
            }
        }
        holder.tvBookAuthor.setText("作者：" + author);

        holder.tvBookSubtitle.setText(bean.getSubtitle());

        holder.tvBookPublisher.setText("出版社：" + bean.getPublisher());

        holder.cv_book.setOnClickListener(new View.OnClickListener() {
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
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout rlLook;
        private ImageView ivBook;
        private LinearLayout llBook;
        private TextView tvBookTitle;
        private TextView tvBookAuthor;
        private TextView tvBookSubtitle;
        private TextView tvBookRating;
        private TextView tvBookPublisher;
        private CardView cv_book;

        public ViewHolder(View view) {
            super(view);
            rlLook = (RelativeLayout) view.findViewById(R.id.rl_look);
            ivBook = (ImageView) view.findViewById(R.id.iv_book);
            llBook = (LinearLayout) view.findViewById(R.id.ll_book);
            tvBookTitle = (TextView) view.findViewById(R.id.tv_book_title);
            tvBookAuthor = (TextView) view.findViewById(R.id.tv_book_author);
            tvBookSubtitle = (TextView) view.findViewById(R.id.tv_book_subtitle);
            tvBookRating = (TextView) view.findViewById(R.id.tv_book_rating);
            tvBookPublisher = (TextView) view.findViewById(R.id.tv_book_publisher);
            cv_book = (CardView) view.findViewById(R.id.cv_book);
        }
    }
}
