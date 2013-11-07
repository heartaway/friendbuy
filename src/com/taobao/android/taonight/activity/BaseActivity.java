package com.taobao.android.taonight.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.taobao.android.taonight.R;
//import com.taobao.android.taonight.adapter.CategoryGroupAdapter;
import com.taobao.android.taonight.utility.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-11
 * To change this template use File | Settings | File Templates.
 */
public class BaseActivity extends Activity {
    PopupWindow categoryWindow;

    List<String> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
    }

    protected void netConnect() {
        //TO DO
    }

    protected void initCategoryListener(int id) {
        View categoryView = findViewById(id);
        categoryView.setOnClickListener(getCategoryListener());
    }

    protected void initAddRecommendListener(int id) {
        View addRecommendView = findViewById(id);
        addRecommendView.setOnClickListener(this.getAddRecommendListener());
    }

    protected View.OnClickListener getCategoryListener() {

        View.OnClickListener listene = new View.OnClickListener() {
            public void onClick(View v) {
                showCategory(v);
            }
        };
        return listene;
    }

    protected void showCategory(View parent) {
        ListView lv_group;
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.category_list, null);
        lv_group = (ListView) view.findViewById(R.id.lvGroup);
        groups = new ArrayList<String>();
        groups.add("服装服饰");
        groups.add("箱包配饰");
        groups.add("妈咪宝贝");
        groups.add("家居美食");
        groups.add("数码家电");
        groups.add("美容护发");
//        CategoryGroupAdapter groupAdapter = new CategoryGroupAdapter(this, groups);
//        lv_group.setAdapter(groupAdapter);
        categoryWindow = new PopupWindow(view, 150, 210);
        categoryWindow.setFocusable(true);
        categoryWindow.setOutsideTouchable(true);
        categoryWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int hideWidth = 340; 
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2 - hideWidth / 2 - categoryWindow.getWidth() / 2;
        Log.i("coder", "xPos:" + xPos);
        categoryWindow.showAsDropDown(parent, xPos, 0);
        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                if (categoryWindow != null) {
                    categoryWindow.dismiss();
                }
            }
        });
    }

    protected View.OnClickListener getAddRecommendListener() {
        View.OnClickListener listene = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, AddRecommendActivity.class);
                BaseActivity.this.startActivity(intent);
                BaseActivity.this.finish();
            }
        };
        return listene;
    }


    protected void DisplayToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
