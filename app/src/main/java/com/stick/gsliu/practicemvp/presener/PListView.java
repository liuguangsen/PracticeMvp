package com.stick.gsliu.practicemvp.presener;

import com.stick.gsliu.practicemvp.modle.MListView;
import com.stick.gsliu.practicemvp.modle.TestMListView;
import com.stick.gsliu.practicemvp.view.VListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1505019 on 2018/2/8.
 *  总开关
 */

public class PListView{

    private WeakReference<VListView> vlv;
    private MListView mListView ;

    public PListView(VListView vlv) {
        this.vlv = new WeakReference<VListView>(vlv);
        mListView = new TestMListView();
    }

    public void getData() {
        if (vlv.get()!=null){
            vlv.get().showLoading("开始加载");
        }
        mListView.updateListView(new MListView.DataCallback() {
            @Override
            public void onSuccess(List list) {
                if (vlv.get()!=null){
                    vlv.get().showLoading("加载成功");
                    vlv.get().updateListView((ArrayList<String>) list);
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                if (vlv.get()!=null){
                    vlv.get().showLoading("加载失败");
                }
            }
        });
    }
}
