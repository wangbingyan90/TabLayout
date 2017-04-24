package com.wangby.www.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTabLayout(View v){
        startActivity(new Intent(this, TabLayoutActivity.class));
    }
    public void onClickdownLayout(View v){
        startActivity(new Intent(this, TabLayoutBottomActivity.class));
    }

    public void complete(View v){
//        startActivity(new Intent(this, HomeActivity.class));
    }
}
