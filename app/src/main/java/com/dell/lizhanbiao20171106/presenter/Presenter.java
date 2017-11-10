package com.dell.lizhanbiao20171106.presenter;

import com.dell.lizhanbiao20171106.bean.News;
import com.dell.lizhanbiao20171106.login.LoggingInterceptor;
import com.dell.lizhanbiao20171106.model.Imodel;
import com.dell.lizhanbiao20171106.model.Model;
import com.dell.lizhanbiao20171106.view.Iview;

import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by DELL on 2017/11/6.
 */

public class Presenter implements Model.OnFinish {
    Iview iview;
    Model model;

    public Presenter(Iview iview) {
        this.iview = iview;
        this.model = new Model();
        model.setOnFinish(this);
    }

    public void getUrl(String url){
        model.RequestSuccess(url);
    }

    @Override
    public void OnFinshListener(List<News.SongListBean> list) {
        iview.showSuccess(list);
    }
}
