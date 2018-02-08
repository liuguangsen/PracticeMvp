package com.stick.gsliu.practicemvp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stick.gsliu.practicemvp.presener.PListView;
import com.stick.gsliu.practicemvp.view.VListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements VListView {

    private ListView listView;
    private PListView pListView;
    private PictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        pListView = new PListView(this);
        pListView.getData();

    }

    @Override
    public void showLoading(String message) {
        Toast.makeText(this,message+"。。。。。。",Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateListView(ArrayList<String> dataCallback) {
        adapter = new PictureAdapter(dataCallback);
        listView.setAdapter(adapter);
    }


    private static class PictureAdapter extends BaseAdapter {

        private ArrayList<String> datas;

        PictureAdapter(ArrayList<String> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas == null ? 0 : datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                /*TextView textView = new TextView(parent.getContext());
                textView.setLayoutParams(new ViewGroup.LayoutParams(100,100));
                textView.setBackgroundColor(Color.RED);
                convertView = textView;*/
                //convertView = View.inflate(parent.getContext(), R.layout.item_list_view_tv_view, null);
                convertView = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_list_view_tv_view, parent,false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //用文字区别item
            viewHolder.tv.setText(datas.get(position) + " teststeststse");
            return convertView;
        }

        private static class ViewHolder {
            final TextView tv;
            ViewHolder(View view) {
                tv = view.findViewById(R.id.tv);
            }
        }
    }
}
