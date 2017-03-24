package ai.yale.wxserver.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.bean.Article;
import ai.yale.wxserver.util.Configuration;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.AccessTokenVo;
import ai.yale.wxserver.vo.WxVo;

/**
 * 微信消息服务
 * @author 吕佳
 * 
 */
@Service
public class WxService {
	
	@Autowired
	WxUtils wxUtils;
	
	public AccessTokenVo accessTokenVo;
	public Long lastRefreshedTime;
	/**
	 * 微信配置
	 * @param vo
	 * @return
	 */
	public String wxConfig(WxVo vo) {

		if (vo.getSignature() == null || vo.getTimestamp() == null || vo.getNonce() == null) {
			return null;
		}

		if (wxUtils.checkSignature(vo.getSignature(), vo.getTimestamp(), vo.getNonce())) {
			return vo.getEchostr();
			
		} else {
			return null;
		}
	}

	/**
	 * 微信消息
	 * @param request
	 * @return
	 */
	public String wxMessage(HttpServletRequest request) {

		Map<String, String> map = wxUtils.receiveMessage(request);
//		System.out.println(map.toString());
		if (map == null || map.size() == 0) {
			return null;
		}
		
		// 微信消息类型判断
		String msgType = map.get("MsgType");
		String reply = null;
		
		switch (msgType) {
		case Configuration.MESSAGE_TEXT:
			 reply = wxUtils.replyTextMessage(map, "你好");
			 // System.out.println(reply);
			
//			if (map.get("Content").equals("1")) {
//				Article article = new Article();
//				article.setTitle("测试公众号");
//				article.setDescription("测试描述");
//				article.setPicUrl("http://img3.imgtn.bdimg.com/it/u=2487184179,3100424350&fm=23&gp=0.jpg");
//				article.setUrl("http://www.baidu.com");
//				
//				List<Article> articles = new ArrayList<>();
//				articles.add(article);
//
//				Article article1 = new Article();
//				article1.setTitle("测试公众号2");
//				article1.setDescription("测试描述2");
//				article1.setPicUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1353085406,3342692239&fm=23&gp=0.jpg");
//				article1.setUrl("http://www.baidu.com");
//				
//				articles.add(article1);
//				reply = wxUtils.replyNewsMessage(map, articles);
//				// System.out.println(reply);
//			} else if (map.get("Content").equals("2")) {
//				Article article = new Article();
//				article.setTitle("测试公众号2");
//				article.setDescription("测试描述2");
//				article.setPicUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1353085406,3342692239&fm=23&gp=0.jpg");
//				article.setUrl("http://www.baidu.com");
//				
//				List<Article> articles = new ArrayList<>();
//				articles.add(article);
//
//				reply = wxUtils.replyNewsMessage(map, articles);
//			}

			break;
		case Configuration.MESSAGE_EVENT:
			String event = map.get("Event");
			if (Configuration.MESSAGE_SUBSCRIBE.equals(event)) {
				// 订阅消息
				reply = wxUtils.replyTextMessage(map, "你好，欢迎订阅房公信");
			} else if (Configuration.MESSAGE_UNSUBSCRIBE.equals(event)) {
				// 取消订阅消息
				reply = wxUtils.replyTextMessage(map, "。。。");
			}
			break;
		case Configuration.MESSAGE_IMAGE:
			
			break;
		case Configuration.MESSAGE_LINK:
			
			break;

		default:
			break;
		}
		
		return reply;	

	}
	
	/**
	 * 定时access token 检查任务，防止网络原因造成服务不可用
	 */
	@Scheduled(fixedRate = 60000)
	public void checkAccessToken() {
		//System.out.println("检查 access token");
		if (accessTokenVo == null || "".equals(accessTokenVo.getAccess_token())) {
			// 如果不存在
			accessTokenVo = wxUtils.getAccessToken();
			lastRefreshedTime = new Date().getTime();
		} else {
			// 检查有效时间 设置为7000秒
			Long currentTime = new Date().getTime();
			if (currentTime - lastRefreshedTime > 7000 * 1000) {
				accessTokenVo = wxUtils.getAccessToken();
				lastRefreshedTime = new Date().getTime();
			}
		}
	}
	
	/**
	 * 获取微信access token
	 * @return
	 */
	public RespMessage wxAccessToken() {
		if (accessTokenVo == null || "".equals(accessTokenVo.getAccess_token())) {
			return RespMessage.error("服务器暂时未获取AccessToken，请稍后再试");
		} else {
			return RespMessage.success(accessTokenVo);
		}
	}
	
}
