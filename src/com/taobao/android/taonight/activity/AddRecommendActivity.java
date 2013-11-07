package com.taobao.android.taonight.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import com.taobao.android.taonight.R;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-11
 * To change this template use File | Settings | File Templates.
 */
public class AddRecommendActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recommend);
        init();
    }


    private void init() {
        initCategoryListener(R.id.toolbar_add_recommend_category);
        initBackListener(R.id.toolbar_add_recommend_back);
    }

    protected void initBackListener(int id) {
        View backView = findViewById(id);
        backView.setOnClickListener(getbackListener());
    }

    protected View.OnClickListener getbackListener() {

        View.OnClickListener listene = new View.OnClickListener() {
            public void onClick(View v) {
                toBack(v);
            }
        };
        return listene;
    }

    protected void toBack(View view) {
        Intent oldIntent = getIntent();
        Bundle bundle = oldIntent.getExtras();
        String className = bundle.getString("from");
        Intent intent;
//        if (className.equalsIgnoreCase("FriendRecommendActivity")) {
//            intent = new Intent(AddRecommendActivity.this, FriendRecommendActivity.class);
//        } else if (className.equalsIgnoreCase("MyRecommendActivity")) {
//            intent = new Intent(AddRecommendActivity.this, MyRecommendActivity.class);
//        } else if (className.equalsIgnoreCase("HotRecommendActivity")) {
//            intent = new Intent(AddRecommendActivity.this, HotRecommendActivity.class);
//        } else {
//            intent = new Intent(AddRecommendActivity.this, MenuActivity.class);
//        }
        intent = new Intent(AddRecommendActivity.this, MenuActivity.class);
        AddRecommendActivity.this.startActivity(intent);
        AddRecommendActivity.this.finish();
    }

}
