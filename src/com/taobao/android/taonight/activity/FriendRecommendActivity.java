package com.taobao.android.taonight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.taobao.android.taonight.R;
import com.taobao.android.taonight.utility.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-11
 * To change this template use File | Settings | File Templates.
 */
public class FriendRecommendActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_recommend);
        init();
    }


    private void init() {
        initCategoryListener(R.id.toolbar_friend_recommend_category);
        initAddRecommendListener(R.id.toolbar_friend_recommend_add);
    }

    protected View.OnClickListener getAddRecommendListener() {
        View.OnClickListener listene = new View.OnClickListener() {
            public void onClick(final View v) {
                Intent intent = new Intent(FriendRecommendActivity.this, AddRecommendActivity.class);
                intent.putExtra("from", "FriendRecommendActivity");
                FriendRecommendActivity.this.startActivity(intent);
                FriendRecommendActivity.this.finish();
            }
        };
        return listene;
    }

}
