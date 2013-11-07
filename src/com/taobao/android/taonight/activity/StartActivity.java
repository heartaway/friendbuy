package com.taobao.android.taonight.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.taobao.android.taonight.R;
import com.taobao.android.taonight.httpclient.TBHttpClient;
import com.taobao.android.taonight.utility.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-11
 * To change this template use File | Settings | File Templates.
 */
public class StartActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.start);
        runStart();
    }

    private void runStart() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                netConnect();
//                Intent intent = new Intent(StartActivity.this,MenuActivity.class);
                Intent intent = new Intent(StartActivity.this,LoginActivity.class);
                StartActivity.this.startActivity(intent);
                StartActivity.this.finish();
            }

        }, Constant.SPLASH_DISPLAY_TIME);
    }


}
