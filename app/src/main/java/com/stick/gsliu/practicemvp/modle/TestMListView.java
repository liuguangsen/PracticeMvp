package com.stick.gsliu.practicemvp.modle;

import java.util.ArrayList;

/**
 * Created by 1505019 on 2018/2/8.
 *  测试数据相关
 */

public class TestMListView implements MListView{
    @Override
    public void updateListView(DataCallback dataCallback) {
        ArrayList<String> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        dataCallback.onSuccess(list);
    }
}
