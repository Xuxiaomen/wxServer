package ai.yale.wxserver.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  
@ConfigurationProperties(prefix="configuration") //接收application.yml中的configEntity下面的属性 
public class Configuration {
	// 请求消息类型：文本
	public static final String MESSAGE_TEXT = "text";
	// 请求消息类型：图片 
	public static final String MESSAGE_IMAGE = "image";
	// 请求消息类型：图文 
	public static final String MESSAGE_NEWS = "news"; 
	// 请求消息类型：音频 
	public static final String MESSAGE_VOICE = "voice"; 
	// 请求消息类型：视频 
	public static final String MESSAGE_VIDEO = "video"; 
	// 请求消息类型：链接 
	public static final String MESSAGE_LINK = "link"; 
	// 请求消息类型：地理位置 
	public static final String MESSAGE_LOCATION = "location";
	// 请求消息类型：推送 
	public static final String MESSAGE_EVENT = "event";
	// 事件类型：关注 
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	// 事件类型：取消关注 
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	// 事件类型：自定义菜单点击事件 
	public static final String MESSAGE_CLICK = "CLICK";
	// 事件类型：自定义菜单链接跳转事件 
	public static final String MESSAGE_VIEW = "VIEW";
	//
	public static String token;
	// 测试号lvjia
	// public static final String APPID = "wxede20d9286db6756";
	// public static final String APPSECRET =
	// "b548de5f324a3abc9cab2d9d32c49e15";
	// 测试号xumeng
	// 微信服务号ID
	public String appId; 
	// 微信服务号密钥
	public String appSecret;
	//公众平台的API调用所需的access_token接口的URL地址
	public String access_token_url;
	//公众平台的API调用临时素材的mediaId接口的URL地址
	public String upload_temprory_meterial_url; 
	// public static final String UPLOAD_METERIAL_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN
	// public static final String UPLOAD_NEWS_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
	//自定义菜单创建接口的URL地址
	public String  create_menu_url; 
	//JSAPI调用所需的jsapi_ticket接口的URL地址
	public String  jsapi_ticket_url; 
	//生成JS-SDK权限验证的签名
	public String  jsapi_sign_string; 
	//创建二维码ticket请求的URL地址
	public String  create_qrCode_url;
	//通过ticket换取二维码图片的URL地址
	public String  create_qrCodeImage_url;
	//长链接转短链接接口的URL地址
	public String  longLink_to_shortLink_url; 
	//用户分析中获取用户增减数据接口
	public String  getUserSummary_url; 
	//用户分析中获取累计用户数据接口
	public String  getUserCumulate_url; 
	//
	public String  weixinFaqRobot_url;
	
	public String getToken() {
		return token;
	}
	public static void setToken(String token) {
		Configuration.token = token;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getAccess_token_url() {
		return access_token_url;
	}
	public void setAccess_token_url(String access_token_url) {
		this.access_token_url = access_token_url;
	}
	public String getUpload_temprory_meterial_url() {
		return upload_temprory_meterial_url;
	}
	public void setUpload_temprory_meterial_url(String upload_temprory_meterial_url) {
		this.upload_temprory_meterial_url = upload_temprory_meterial_url;
	}
	public String getCreate_menu_url() {
		return create_menu_url;
	}
	public void setCreate_menu_url(String create_menu_url) {
		this.create_menu_url = create_menu_url;
	}
	public String getJsapi_ticket_url() {
		return jsapi_ticket_url;
	}
	public void setJsapi_ticket_url(String jsapi_ticket_url) {
		this.jsapi_ticket_url = jsapi_ticket_url;
	}
	public String getJsapi_sign_string() {
		return jsapi_sign_string;
	}
	public void setJsapi_sign_string(String jsapi_sign_string) {
		this.jsapi_sign_string = jsapi_sign_string;
	}
	public String getCreate_qrCode_url() {
		return create_qrCode_url;
	}
	public void setCreate_qrCode_url(String create_qrCode_url) {
		this.create_qrCode_url = create_qrCode_url;
	}
	public String getCreate_qrCodeImage_url() {
		return create_qrCodeImage_url;
	}
	public void setCreate_qrCodeImage_url(String create_qrCodeImage_url) {
		this.create_qrCodeImage_url = create_qrCodeImage_url;
	}
	public String getLongLink_to_shortLink_url() {
		return longLink_to_shortLink_url;
	}
	public void setLongLink_to_shortLink_url(String longLink_to_shortLink_url) {
		this.longLink_to_shortLink_url = longLink_to_shortLink_url;
	}
	public String getGetUserSummary_url() {
		return getUserSummary_url;
	}
	public void setGetUserSummary_url(String getUserSummary_url) {
		this.getUserSummary_url = getUserSummary_url;
	}
	public String getGetUserCumulate_url() {
		return getUserCumulate_url;
	}
	public void setGetUserCumulate_url(String getUserCumulate_url) {
		this.getUserCumulate_url = getUserCumulate_url;
	}
	public String getWeixinFaqRobot_url() {
		return weixinFaqRobot_url;
	}
	public void setWeixinFaqRobot_url(String weixinFaqRobot_url) {
		this.weixinFaqRobot_url = weixinFaqRobot_url;
	}
	public static String getMessageText() {
		return MESSAGE_TEXT;
	}
	public static String getMessageImage() {
		return MESSAGE_IMAGE;
	}
	public static String getMessageNews() {
		return MESSAGE_NEWS;
	}
	public static String getMessageVoice() {
		return MESSAGE_VOICE;
	}
	public static String getMessageVideo() {
		return MESSAGE_VIDEO;
	}
	public static String getMessageLink() {
		return MESSAGE_LINK;
	}
	public static String getMessageLocation() {
		return MESSAGE_LOCATION;
	}
	public static String getMessageEvent() {
		return MESSAGE_EVENT;
	}
	public static String getMessageSubscribe() {
		return MESSAGE_SUBSCRIBE;
	}
	public static String getMessageUnsubscribe() {
		return MESSAGE_UNSUBSCRIBE;
	}
	public static String getMessageClick() {
		return MESSAGE_CLICK;
	}
	public static String getMessageView() {
		return MESSAGE_VIEW;
	}
}