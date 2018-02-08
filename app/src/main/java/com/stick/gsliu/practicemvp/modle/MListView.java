package com.stick.gsliu.practicemvp.modle;

import java.util.List;

/**
 * Created by 1505019 on 2018/2/8.
 *  数据获取的方法
 */

public interface MListView {

    void updateListView(MListView.DataCallback dataCallback);

    interface DataCallback {
        void onSuccess(List list);

        void onFailed(String errorMessage);
    }
}
