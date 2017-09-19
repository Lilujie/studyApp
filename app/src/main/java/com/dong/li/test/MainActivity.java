package com.dong.li.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.logOn);
        btn.setOnClickListener(new LogInButtonOnClickListener());
        EditText text_passwd = (EditText)MainActivity.this.findViewById(R.id.passwd);
        text_passwd.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                final ScrollView scrollView_main = (ScrollView)MainActivity.this.findViewById(R.id.scrollView);
                if (hasFocus) {
                    Log.e("MainActivity", "获得焦点");
                    scrollView_main.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView_main.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                } else {
                    Log.e("MainActivity", "失去焦点");
                    scrollView_main.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView_main.fullScroll(ScrollView.FOCUS_UP);
                        }
                    });
                }
            }
        });
    }
    private class LogInButtonOnClickListener implements OnClickListener{
        public void onClick(View v) {
            EditText text_userId = (EditText)MainActivity.this.findViewById(R.id.userId);
            EditText text_passwd = (EditText)MainActivity.this.findViewById(R.id.passwd);
            if(true/*(text_userId.getText().toString().equals("") ) && (text_passwd.getText().toString().equals(""))*/) {
                Log.e(getLocalClassName(), "登录成功！");
                startActivity(new Intent("com.dong.li.test.SecondActivity"));
            } else {
                Toast.makeText(MainActivity.this, "账号或密码错误!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
