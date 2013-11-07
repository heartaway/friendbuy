package com.taobao.android.taonight.utility;

/**
 * Created with IntelliJ IDEA. User: xinyuan.ymm To change this template use
 * File | Settings | File Templates.
 * 
 * http://10.235.170.138:8089/recommend/HotList?page=1&category=1
 * http://10.235.170.138:8089/recommend/MyList?page=1&category=1
 * http://10.235.170.138:8089/recommend/FriendsList?page=1&category=1
 * 
 * http://10.235.170.138:8089/category/all.htm
 * http://10.235.170.138:8089/comment/list.htm?id=1&page=1
 * http://10.235.170.138:8089/comment/add.htm?id=1&userId=12&content=abc
 * 
 * http://10.235.170.138:8089/favorite/Add?id=6
 * http://10.235.170.138:8089/recommend/Detail?id=6
 * http://10.235.170.138:8089/Shophistory?page=1
 * http://10.235.170.138:8089/recommend/Add?id=1&category=1&content=测试中&taobao_iid=19605020672
 */
public class Constant {

	public static int SPLASH_DISPLAY_TIME = 1000;

	/* 服务器ip */
	public static String IP = "10.235.170.138";

	/* 热门推荐 */
	public static String HOTLIST_URL = "http://" + IP + ":8089"+ "/recommend/HotList";
	/* 我的推荐 */
	public static String MYLIST_URL = "http://" + IP + ":8089"+ "/recommend/MyList";
	/* 好友推荐 */
	public static String FRIENDLIST_URL = "http://" + IP + ":8089"+ "/recommend/FriendsList";
	/* 添加推荐 */
	public static String RECOMMEND_ADD_URL = "http://" + IP + ":8089"+ "/recommend/Add";
	/* 推荐详情 */
	public static String RECOMMEND_DETAIL_URL = "http://" + IP + ":8089"+ "/recommend/Detail";
	/* 分类 */
	public static String CATEGORY_URL = "http://" + IP + ":8089"+ "/category/all";
	/* 评论列表 */
	public static String COMMENT_LIST_URL = "http://" + IP + ":8089"+ "/comment/list";
	/* 评论添加 */
	public static String COMMENT_ADD_URL = "http://" + IP + ":8089"+ "/comment/add";
	/* 喜欢 */
	public static String FAVORITE_ADD_URL = "http://" + IP + ":8089"+ "/favorite/Add";
	/* 购买列表 */
	public static String SHOPHISTORY_URL = "http://" + IP + ":8089"+ "/Shophistory";

}
