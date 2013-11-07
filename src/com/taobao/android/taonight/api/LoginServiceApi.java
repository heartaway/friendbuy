package com.taobao.android.taonight.api;

import com.taobao.cli.annotation.API;
import com.taobao.cli.annotation.HttpMethodType;
import com.taobao.cli.annotation.JsonParam;
import com.taobao.cli.annotation.MTopParam;
import com.taobao.cli.annotation.MTopTimestampParam;
import com.taobao.cli.annotation.MtopLoginAuth;
import com.taobao.cli.annotation.Param;
import com.taobao.cli.annotation.URL;
import com.taobao.cli.annotation.Version;
import com.taobao.cli.vo.ApiResponse;


public interface LoginServiceApi {
	
	
	@MtopLoginAuth(loginAuth=true)
	@URL(link="http://api.m.taobao.com/rest/api2.do")
	@API(name="com.taobao.wireless.sys.getLoginImToken")
	@MTopParam(key="data")
	@Version(value="*")
	public ApiResponse getLoginImToken(@Param(key="sid")String sid );
	
	
	@URL(link="http://api.m.taobao.com/rest/api2.do")
	@API(name="com.taobao.wireless.mtop.getLoginUrl")
	@MTopParam(key="data")
	@Version(value="*")
	public ApiResponse getLoginUrl(@Param(key="appkey")String appkey , @Param(key="callbackUrl")String callbackUrl);
	
	
	@URL(link="http://api.m.taobao.com/rest/api2.do")
	@API(name="com.taobao.client.sys.getRsa")
	@MTopParam(key="data")
	@Version(value="*")
	public ApiResponse getRsa();
	

	
	@URL(link="http://api.waptest.taobao.com/rest/api2.do")
	@API(name="com.taobao.client.sys.login")	
	@MTopParam(key="data")
	@Version(value="v2")
	@HttpMethodType(value="GET")
	public ApiResponse loginV2(@Param(key="username")String username, @Param(key="password")String password, 
			@Param(key="token")String token, @Param(key="topToken")String topToken, @Param(key="appKey")String appKey,
			@MTopTimestampParam(key="t")String t);
	
	@URL(link="http://api.m.taobao.com/rest/api2.do")
	@API(name="com.taobao.client.sys.getAppToken")
	@MTopParam(key="data")
	@Version(value="*")
	@HttpMethodType(value="GET")
	public ApiResponse getAppToken(@Param(key="key")String data);
	
	@URL(link="http://api.m.taobao.com/rest/api2.do")
	@API(name="com.taobao.client.sys.getDyRsa")
	@MTopParam(key="data")
	@Version(value="*")
	@HttpMethodType(value="GET")
	public ApiResponse getDyRsa(@Param(key="nick")String nick);
}
