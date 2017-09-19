package com.dong.li.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SongsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setText("This is the Songs tab");
        Log.e(getLocalClassName(),textview.getText().toString());
        setContentView(textview);
    }

}