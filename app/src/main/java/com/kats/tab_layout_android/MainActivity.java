package com.kats.tab_layout_android;

import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChat;
    TabItem tabCall;
    TabItem tabStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("TAB_LAYOUT");

        tabLayout = (TabLayout)findViewById(R.id.tablayout);

        tabCall = (TabItem)findViewById(R.id.tabCalls);
        tabChat = (TabItem)findViewById(R.id.tabChats);
        tabStatus = (TabItem)findViewById(R.id.tabStatus);

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager() , tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 0)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color1));

                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color1));

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this , R.color.color1));
                }

                else if(tab.getPosition() == 1)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color2));

                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color2));

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this , R.color.color2));

                }

                else if(tab.getPosition() == 2)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color3));

                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this , R.color.color3));

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this , R.color.color3));

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
