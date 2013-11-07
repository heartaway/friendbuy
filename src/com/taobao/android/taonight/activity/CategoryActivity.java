package com.taobao.android.taonight.activity;

import android.os.Bundle;
import android.view.Window;
import com.taobao.android.taonight.R;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-14
 * To change this template use File | Settings | File Templates.
 */
public class CategoryActivity extends  BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView(R.layout.main);


    }
}
