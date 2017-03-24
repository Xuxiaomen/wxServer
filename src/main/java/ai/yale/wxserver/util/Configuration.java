package ai.yale.wxserver.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: Configuration
 * @Description: 接收配置信息
 * @author 徐梦
 */

@Component
@ConfigurationProperties(prefix = "configuration") // 接收application.yml中的configEntity下面的属性
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
	// 微信发送的Token验证
	public static String token;
	// 微信服务号ID
	public String appId;
	// 微信服务号密钥
	public String appSecret;
	// 公众平台的API调用所需的access_token接口的URL地址
	public String accessTokenUrl;
	// 公众平台的API调用临时素材的mediaId接口的URL地址
	public String uploadTemproryMeterialUrl;
	// public static final String UPLOAD_METERIAL_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN
	// public static final String UPLOAD_NEWS_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
	// 自定义菜单创建接口的URL地址
	public String createMenuUrl;
	// JSAPI调用所需的jsapi_ticket接口的URL地址
	public String jsapiTicketUrl;
	// 生成JS-SDK权限验证的签名
	public String jsapiSignString;
	// 创建二维码ticket请求的URL地址
	public String createQrcodeUrl;
	// 通过ticket换取二维码图片的URL地址
	public String createQrcodeimageUrl;
	// 长链接转短链接接口的URL地址
	public String longlinkToShortlinkUrl;
	// 用户分析中获取用户增减数据接口
	public String getUserSummaryUrl;
	// 用户分析中获取累计用户数据接口
	public String getUserCumulateUrl;

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

	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public String getUploadTemproryMeterialUrl() {
		return uploadTemproryMeterialUrl;
	}

	public void setUploadTemproryMeterialUrl(String uploadTemproryMeterialUrl) {
		this.uploadTemproryMeterialUrl = uploadTemproryMeterialUrl;
	}

	public String getCreateMenuUrl() {
		return createMenuUrl;
	}

	public void setCreateMenuUrl(String createMenuUrl) {
		this.createMenuUrl = createMenuUrl;
	}

	public String getJsapiTicketUrl() {
		return jsapiTicketUrl;
	}

	public void setJsapiTicketUrl(String jsapiTicketUrl) {
		this.jsapiTicketUrl = jsapiTicketUrl;
	}

	public String getJsapiSignString() {
		return jsapiSignString;
	}

	public void setJsapiSignString(String jsapiSignString) {
		this.jsapiSignString = jsapiSignString;
	}

	public String getCreateQrcodeUrl() {
		return createQrcodeUrl;
	}

	public void setCreateQrcodeUrl(String createQrcodeUrl) {
		this.createQrcodeUrl = createQrcodeUrl;
	}

	public String getCreateQrcodeimageUrl() {
		return createQrcodeimageUrl;
	}

	public void setCreateQrcodeimageUrl(String createQrcodeimageUrl) {
		this.createQrcodeimageUrl = createQrcodeimageUrl;
	}

	public String getLonglinkToShortlinkUrl() {
		return longlinkToShortlinkUrl;
	}

	public void setLonglinkToShortlinkUrl(String longlinkToShortlinkUrl) {
		this.longlinkToShortlinkUrl = longlinkToShortlinkUrl;
	}

	public String getGetUserSummaryUrl() {
		return getUserSummaryUrl;
	}

	public void setGetUserSummaryUrl(String getUserSummaryUrl) {
		this.getUserSummaryUrl = getUserSummaryUrl;
	}

	public String getGetUserCumulateUrl() {
		return getUserCumulateUrl;
	}

	public void setGetUserCumulateUrl(String getUserCumulateUrl) {
		this.getUserCumulateUrl = getUserCumulateUrl;
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