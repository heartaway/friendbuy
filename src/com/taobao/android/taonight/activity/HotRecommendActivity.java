package com.taobao.android.taonight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.taobao.android.taonight.R;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-11
 * To change this template use File | Settings | File Templates.
 */
public class HotRecommendActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_recommend);
        init();
    }

    private void init() {
        initCategoryListener(R.id.toolbar_hot_recommend_category);
        initAddRecommendListener(R.id.toolbar_hot_recommend_add);
    }

    protected View.OnClickListener getAddRecommendListener() {
        View.OnClickListener listene = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotRecommendActivity.this, AddRecommendActivity.class);
                intent.putExtra("from", "HotRecommendActivity");
                HotRecommendActivity.this.startActivity(intent);
                HotRecommendActivity.this.finish();
            }
        };
        return listene;
    }
}
