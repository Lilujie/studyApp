package com.dong.li.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.logOn);
        btn.setOnClickListener(new MyOnClickListener());
    }
    private class MyOnClickListener implements OnClickListener{
        public void onClick(View v) {
            EditText text = (EditText)MainActivity.this.findViewById(R.id.userId);
            EditText text_2 = (EditText)MainActivity.this.findViewById(R.id.passwd);
            if((text.getText().toString().equals("") ) && (text_2.getText().toString().equals(""))) {
                //Toast.makeText(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent("com.dong.li.test.SecondActivity"));
            } else {
                Toast.makeText(MainActivity.this, "账号或密码错误!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
