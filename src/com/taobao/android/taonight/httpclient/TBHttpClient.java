package com.taobao.android.taonight.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class TBHttpClient {

	
	public static HttpClient httpClient = new DefaultHttpClient();
	volatile  Boolean isOK=false;

	
	public abstract String getUri(Integer actionCode,String ...args);
	
	
	private String sendMessage(final HttpUriRequest request){
		
		 final StringBuffer xml =new StringBuffer();
			
		new Thread(){
		    @Override
		    public void run() {
		        try {
		        	HttpResponse httpResponse = httpClient.execute(request);
		        	HttpEntity entity=httpResponse.getEntity();
		        	if(entity!=null){		
						BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"utf-8"));
						String line =null;
						while((line=br.readLine())!=null){
							xml.append(line);
						}	
					}	
		        }
		        catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch(Exception e){
					e.printStackTrace();
				}  
		        isOK=true;
		    }
		}.start();
		
		while(!isOK);
		
		return xml.toString();
	}
	
	public String doGet(Integer actionCode,String... arg){
		String uri =getUri(actionCode ,arg);
		final HttpGet httpGet =new HttpGet(uri);
		String result = sendMessage(httpGet);
		return result;
	}
	
	public String doPost(Integer actionCode,String... arg){
		String uri =getUri(actionCode ,arg);
		final HttpGet httpGet =new HttpGet(uri);
		String result = sendMessage(httpGet);
		return result;
	}
	
	
}
