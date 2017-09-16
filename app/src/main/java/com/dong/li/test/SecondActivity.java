package com.dong.li.test;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 李璐洁 on 2017/9/9.
 */

public class SecondActivity extends AppCompatActivity {
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = new ListView(this);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity_second,
                new String[]{"contact","address","img","num"},
                new int[]{R.id.contact,R.id.address,R.id.img,R.id.num});
        listView.setAdapter(adapter);
        setContentView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                TextView tv = (TextView)arg1.findViewById(R.id.num);
                String str = tv.getText().toString();
                //Toast.makeText(SecondActivity.this, str, Toast.LENGTH_LONG).show();
                callPhone(str);
            }
        });
    }
    public void callPhone(String str) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str));
        startActivity(intent);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contact", "在强");
        map.put("address", "北京联通");
        map.put("img", R.drawable.i1);
        map.put("num", "13001289014");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("contact", "北京大学口腔医院");
        map.put("address", "北京");
        map.put("img", R.drawable.i2);
        map.put("num", "01082037073");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("contact", "4008205555");
        map.put("address", "未知归属地");
        map.put("img", R.drawable.i3);
        map.put("num", "4008205555");
        list.add(map);

        return list;
    }
}
