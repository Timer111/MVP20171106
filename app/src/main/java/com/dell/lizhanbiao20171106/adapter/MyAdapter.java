package com.dell.lizhanbiao20171106.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dell.lizhanbiao20171106.R;
import com.dell.lizhanbiao20171106.bean.News;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/11/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<News.SongListBean> list = new ArrayList<>();
    private Context context;

    public MyAdapter(List<News.SongListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        holder.music_name.setText(list.get(position).getTitle());
        holder.name.setText(list.get(position).getAuthor());
        Uri uri = Uri.parse(list.get(position).getPic_big());
        holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView music_name;
        private  TextView name;
        private  SimpleDraweeView img;

        public ViewHolder(View itemView) {
            super(itemView);

            music_name = itemView.findViewById(R.id.item_music_name);
            name = itemView.findViewById(R.id.item_name);
            img = itemView.findViewById(R.id.item_simple);
        }
    }
}
