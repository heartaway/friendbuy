package com.taobao.android.taonight.activity;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.android.taonight.R;
import com.taobao.android.taonight.utility.ImageLoadUtil;
import com.taobao.android.taonight.view.SlidingMenuView;


public class MenuActivity extends ActivityGroup {
    SlidingMenuView slidingMenuView;

    ViewGroup menuContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_menu);
        slidingMenuView = (SlidingMenuView) findViewById(R.id.sliding_menu_view);

        menuContent = (ViewGroup) slidingMenuView.findViewById(R.id.sliding_body);
        showDefaultTab();
    }

    public void hideMenu(View view) {
        slidingMenuView.scrollRight();
    }

    public void showMenu(View view) {
        slidingMenuView.scrollLeft();
    }

    public void changeToMyRecommend(View view) {
        Intent i = new Intent(this, MyRecommendActivity.class);
        View v = getLocalActivityManager().startActivity(MyRecommendActivity.class.getName(), i).getDecorView();
        menuContent.removeAllViews();
        menuContent.addView(v);
        selected(R.id.btn_my_recommend);
    }

    public void changeToFriendRecommend(View view) {
        Intent i = new Intent(this, FriendRecommendActivity.class);
        View v = getLocalActivityManager().startActivity(FriendRecommendActivity.class.getName(), i).getDecorView();
        menuContent.removeAllViews();
        menuContent.addView(v);
        selected(R.id.btn_friend_recommend);
    }


    public void changeToHotRecommend(View view) {
        Intent i = new Intent(this, HotRecommendActivity.class);
        View v = getLocalActivityManager().startActivity(HotRecommendActivity.class.getName(), i).getDecorView();
        menuContent.removeAllViews();
        menuContent.addView(v);
        selected(R.id.btn_hot_recommend);
    }

    void showDefaultTab() {
        Intent i = new Intent(this, FriendRecommendActivity.class);
        View v = getLocalActivityManager().startActivity(FriendRecommendActivity.class.getName(), i).getDecorView();
        menuContent.removeAllViews();
        menuContent.addView(v);
        selected(R.id.btn_friend_recommend);
    }

    void selected(int id) {
        String color = "#60513E";
        String colorSelect = "#FFFFFF";
        Bitmap imgSelect = ImageLoadUtil.loadImage(this, R.drawable.icon_indicator_highlited);
        Bitmap imgNoSelect = ImageLoadUtil.loadImage(this, R.drawable.icon_indicator);
        TextView textView = (TextView) findViewById(id);
        if (id == R.id.btn_friend_recommend) {
            textView.setTextColor(Color.parseColor(colorSelect));
            TextView hotView = (TextView) findViewById(R.id.btn_hot_recommend);
            hotView.setTextColor(Color.parseColor(color));
            TextView myView = (TextView) findViewById(R.id.btn_my_recommend);
            myView.setTextColor(Color.parseColor(color));
            ImageView friendImage = (ImageView) findViewById(R.id.icon_friend_recommend);
            friendImage.setImageBitmap(imgSelect);
            ImageView myImage = (ImageView) findViewById(R.id.icon_my_recommend);
            myImage.setImageBitmap(imgNoSelect);
            ImageView hotImage = (ImageView) findViewById(R.id.icon_hot_recommend);
            hotImage.setImageBitmap(imgNoSelect);

        } else if (id == R.id.btn_hot_recommend) {
            textView.setTextColor(Color.parseColor(colorSelect));
            TextView myView = (TextView) findViewById(R.id.btn_my_recommend);
            myView.setTextColor(Color.parseColor(color));
            TextView friendView = (TextView) findViewById(R.id.btn_friend_recommend);
            friendView.setTextColor(Color.parseColor(color));

            ImageView friendImage = (ImageView) findViewById(R.id.icon_friend_recommend);
            friendImage.setImageBitmap(imgNoSelect);
            ImageView myImage = (ImageView) findViewById(R.id.icon_my_recommend);
            myImage.setImageBitmap(imgNoSelect);
            ImageView hotImage = (ImageView) findViewById(R.id.icon_hot_recommend);
            hotImage.setImageBitmap(imgSelect);
        } else if (id == R.id.btn_my_recommend) {
            textView.setTextColor(Color.parseColor(colorSelect));
            TextView hotView = (TextView) findViewById(R.id.btn_hot_recommend);
            hotView.setTextColor(Color.parseColor(color));
            TextView friendView = (TextView) findViewById(R.id.btn_friend_recommend);
            friendView.setTextColor(Color.parseColor(color));

            ImageView friendImage = (ImageView) findViewById(R.id.icon_friend_recommend);
            friendImage.setImageBitmap(imgNoSelect);
            ImageView myImage = (ImageView) findViewById(R.id.icon_my_recommend);
            myImage.setImageBitmap(imgSelect);
            ImageView hotImage = (ImageView) findViewById(R.id.icon_hot_recommend);
            hotImage.setImageBitmap(imgNoSelect);
        } else {
            // nothing
        }
    }

}
