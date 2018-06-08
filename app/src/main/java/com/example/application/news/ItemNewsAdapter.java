package com.example.application.news;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.application.ADetailActivity;
import com.example.application.R;
import com.example.application.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class ItemNewsAdapter extends RecyclerView.Adapter<ItemNewsAdapter.ItemNewsHolder> {

    private List<NewsBean.Bean> objects = new ArrayList<NewsBean.Bean>();
    private Context context;

    public ItemNewsAdapter(Context context){
        this.context = context;
    }

    public void setData(List<NewsBean.Bean> objects){
        this.objects = objects;
    }

    @Override
    public ItemNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new ItemNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemNewsHolder holder, int position) {
        final NewsBean.Bean bean = objects.get(position);
        if (bean == null){
            return;
        }
        Glide.with(context)
                .load(bean.getImgsrc())
                .into(holder.ivNewsImg);
        if (position == 0){
            holder.tvNewsDigest.setVisibility(View.GONE);
            holder.tvNewsTitle.setText("图片：" + bean.getTitle());
        } else {
            holder.tvNewsTitle.setText(bean.getTitle());
            holder.tvNewsDigest.setText(bean.getMtime() + " : " + bean.getDigest());
            holder.cvNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ADetailActivity.class);
                    intent.putExtra("url",bean.getUrl());
                    intent.putExtra("title",bean.getTitle());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    protected class ItemNewsHolder extends RecyclerView.ViewHolder{

        private ImageView ivNewsImg;
        private TextView tvNewsTitle;
        private TextView tvNewsDigest;
        private CardView cvNews;

        public ItemNewsHolder(View view) {
            super(view);
            ivNewsImg = (ImageView) view.findViewById(R.id.iv_news_img);
            tvNewsTitle = (TextView) view.findViewById(R.id.tv_news_title);
            tvNewsDigest = (TextView) view.findViewById(R.id.tv_news_digest);
            cvNews = (CardView) view.findViewById(R.id.cv_news);
        }
    }
}
