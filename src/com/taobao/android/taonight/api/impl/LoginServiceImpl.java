package com.taobao.android.taonight.api.impl;

import com.taobao.android.taonight.api.LoginServiceApi;
import com.taobao.android.taonight.utility.MTopConstants;
import com.taobao.cli.invoker.HttpMethod;
import com.taobao.cli.util.Environment;
import com.taobao.cli.vo.ApiResponse;

/**
 * http://api.waptest.taobao.com/generateSign.htm
* TODO类说明
* @author siru.zjy
* @version 创建时间：2012-11-27
*/
public class LoginServiceImpl extends Environment implements LoginServiceApi {
//	String url ="http://api.waptest.taobao.com/rest/api3.do";
	LoginServiceApi api = (LoginServiceApi) getApiService(LoginServiceApi.class,HttpMethod.GET,MTopConstants.mtop_url);
	@Override
	public ApiResponse getRsa() {
		// TODO Auto-generated method stub
		return  api.getRsa();
	}


	@Override
	public ApiResponse getAppToken(String data) {
		// 
		return  api.getAppToken(data);
	}

	@Override
	public ApiResponse loginV2(String username, String password, String token,
			String topToken, String appKey, String t) {
		// TODO Auto-generated method stub
		return  api.loginV2(username, password, token, topToken, appKey, t);
	}

	@Override
	public ApiResponse getLoginImToken(String sid) {
		// TODO Auto-generated method stub
		return api.getLoginImToken(sid);
	}

	@Override
	public ApiResponse getLoginUrl(String appkey, String callbackUrl) {
		// TODO Auto-generated method stub
		return getLoginUrl(appkey, callbackUrl);
	}

	@Override
	public ApiResponse getDyRsa(String nick) {
		// TODO Auto-generated method stub
		return api.getDyRsa(nick);
	}

}
