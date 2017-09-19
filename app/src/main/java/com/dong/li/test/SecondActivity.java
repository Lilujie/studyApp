package com.dong.li.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
                new String[]{"component","component_name","img"},
                new int[]{R.id.component,R.id.component_name,R.id.img});
        listView.setAdapter(adapter);
        setContentView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                TextView tv = (TextView)arg1.findViewById(R.id.component_name);
                String str = tv.getText().toString();
                callPhone(str);
            }
        });
    }
    public void callPhone(String str) {
        //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + str));
        //startActivity(intent);
        //Toast.makeText(SecondActivity.this, str, Toast.LENGTH_LONG).show();
        Log.e(getLocalClassName(), "str = " + str );
        startActivity(new Intent("com.dong.li.test."+str));
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("component", "选项卡布局Demo");
        map.put("component_name", "TabLayout");
        map.put("img", R.drawable.tablayout);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("component", "表格布局Demo");
        map.put("component_name", "TableLayout");
        map.put("img", R.drawable.tablelayout);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("component", "相对布局Demo");
        map.put("component_name", "RelativeLayout");
        map.put("img", R.drawable.relativelayout);
        list.add(map);

        return list;
    }
}
