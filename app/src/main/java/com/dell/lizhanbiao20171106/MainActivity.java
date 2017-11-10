package com.dell.lizhanbiao20171106;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dell.lizhanbiao20171106.Api.API;
import com.dell.lizhanbiao20171106.adapter.MyAdapter;
import com.dell.lizhanbiao20171106.bean.News;
import com.dell.lizhanbiao20171106.presenter.Presenter;
import com.dell.lizhanbiao20171106.view.Iview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private MyAdapter myAdapter;
    private  List<News.SongListBean> list = new ArrayList<>();
    private TextView bianji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        bianji = (TextView) findViewById(R.id.bianji);
        Presenter presenter = new Presenter(this);
       presenter.getUrl(API.BASE_URL);
        //点击编辑按钮
       bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bianji.getText().equals("编辑")){
                    bianji.setText("完成");
                View view1  = View.inflate(MainActivity.this,R.layout.check_main,null);
                } else{
                    bianji.setText("编辑");
                }
            }
        });
    }

    @Override
    public void showSuccess(List<News.SongListBean> list) {
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        myAdapter = new MyAdapter(list,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void showError(String r) {

    }
}
