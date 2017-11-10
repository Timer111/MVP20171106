package com.dell.lizhanbiao20171106.view;

import com.dell.lizhanbiao20171106.bean.News;

import java.util.List;

/**
 * Created by DELL on 2017/11/6.
 */

public interface Iview {
    void showSuccess(List<News.SongListBean> list);
    void showError(String r);
}
