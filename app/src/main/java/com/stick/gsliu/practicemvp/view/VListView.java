package com.stick.gsliu.practicemvp.view;

import java.util.ArrayList;

/**
 * Created by 1505019 on 2018/2/8.
 *  ui更新
 */

public interface VListView {
    void showLoading(String message);

    void updateListView(ArrayList<String> dataCallback);

}
