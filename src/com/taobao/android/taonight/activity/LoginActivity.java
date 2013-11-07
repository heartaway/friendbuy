package com.taobao.android.taonight.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.taobao.android.taonight.R;
import com.taobao.android.taonight.api.impl.LoginServiceImpl;
import com.taobao.android.taonight.utility.MTopConstants;
import com.taobao.cli.util.Environment;
import com.taobao.cli.util.RSAUtil;
import com.taobao.cli.util.SecurityInfo;
import com.taobao.cli.util.TaoLog;
import com.taobao.cli.vo.ApiResponse;

/**
 * Created with IntelliJ IDEA. User: xinyuan.ymm Date: 13-1-11 Time: ����3:53 To
 * change this template use File | Settings | File Templates.
 */

public class LoginActivity extends BaseActivity implements OnClickListener {

	private static final String TAG = "FriendBuy";
	LoginServiceImpl ls = null;
	String pubKey = null;
	String token = null;
	String sid = "";
	String userName = "";
	String password = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // To change body of overridden
											// methods use File | Settings |
											// File Templates.
		setContentView(R.layout.login);
		findView();
		Environment.init(this, MTopConstants.appkey, MTopConstants.secret,
				MTopConstants.ttid_android);
		Environment.openLog();
		ls = new LoginServiceImpl();

	}

	private void findView() {
		Button btnLogin = (Button) findViewById(R.id.login_btn);
		btnLogin.setOnClickListener(this);
	}

	private void login() throws JSONException {

		String appKey = SecurityInfo.getSecurityInfo().getAppKey();

		if (token == null || pubKey == null) {
			ApiResponse resp = ls.getAppToken(userName);
			// ��ȡ pubKey token
			String node = resp.getData().toString();
			JSONObject jsonObject = new JSONObject(node);
			pubKey = jsonObject.getString("pubKey");
			token = jsonObject.getString("token");
		}

		String encyPwd = RSAUtil.encode(password, pubKey);
		long t = System.currentTimeMillis() / 1000;
		String tStr = String.valueOf(t);

		ApiResponse result = ls.loginV2(userName, encyPwd, token, null, appKey,
				tStr);
		JSONObject jo = new JSONObject(result.getData().toString());
		if (jo.has("ecode")) {
			String ecode = jo.getString("ecode");
			SecurityInfo.getSecurityInfo().setEcode(ecode);
			TaoLog.Logd(TAG, "ecode:" + ecode);
			String sid = jo.getString("sid");
		}
	}

	@Override
	public void onClick(View arg0) {
		// 获取userName和password
		TextView txtUser = (TextView) findViewById(R.id.login_id);
		userName = txtUser.getText().toString().trim();

		TextView txtPwd = (TextView) findViewById(R.id.login_password);
		password = txtPwd.getText().toString().trim();
		

		try {
			login();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
