package com.dong.li.test;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;

public class TabLayoutActivity extends ActivityGroup {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        Log.e(getLocalClassName(), "TabHost three addTab");
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // The activity TabHost
        tabHost.setup(this.getLocalActivityManager());
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ArtistsActivity.class);
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("artists").setIndicator("Artists",
                ContextCompat.getDrawable(this, R.drawable.ic_tab_artists))
                .setContent(intent);
        tabHost.addTab(spec);
        // Do the same for the other tabs
        intent = new Intent().setClass(this, AlbumsActivity.class);
        spec = tabHost.newTabSpec("albums").setIndicator("Albums",
                ContextCompat.getDrawable(this, R.drawable.ic_tab_artists))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, SongsActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Songs",
                ContextCompat.getDrawable(this, R.drawable.ic_tab_artists))
                .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}