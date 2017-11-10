package com.dell.lizhanbiao20171106.model;

import com.dell.lizhanbiao20171106.Api.API;
import com.dell.lizhanbiao20171106.Api.ApiService;
import com.dell.lizhanbiao20171106.bean.News;
import com.dell.lizhanbiao20171106.login.LoggingInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/6.
 */

public class Model implements Imodel {

    private List<News.SongListBean> list = new ArrayList<>();
    OnFinish onFinish;

    public interface OnFinish{
        void OnFinshListener(List<News.SongListBean> list);
    }

    public void setOnFinish(OnFinish onFinish){
        this.onFinish = onFinish;
    }

    @Override
    public void RequestSuccess(String url) {
        OkHttpClient client = new OkHttpClient
			.Builder()
			.addInterceptor(new LoggingInterceptor())
			.build();

        Retrofit retrofit = new Retrofit
			.Builder()
			.baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        final Observable<News> bean = apiService.getSong_list();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news) {
                        List<News.SongListBean> bean = news.getSong_list();
                        onFinish.OnFinshListener(bean);
                    }
                });
    }
}
