package com.dell.lizhanbiao20171106.Api;


import com.dell.lizhanbiao20171106.bean.News;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by DELL on 2017/11/6.
 */

public interface ApiService {
    @GET("ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
    Observable<News> getSong_list();
}
