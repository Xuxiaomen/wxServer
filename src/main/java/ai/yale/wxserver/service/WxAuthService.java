package ai.yale.wxserver.service;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ai.yale.wxserver.util.Configuration;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxMessageConverter;
import ai.yale.wxserver.vo.AccessTokenVo;
import ai.yale.wxserver.vo.UserInfoVo;

/**
 * @Title: WxAuthService
 * @Description: 微信授权登录
 * @author xumeng
 *
 */
@Service
public class WxAuthService {
	
	@Autowired
	Configuration configuration;
	
	/**
	 * @Title: wxAuth
	 * @Description: 用户进入授权页面同意授权，获取code
	 * @param response
	 * @throws IOException
	 */
	public void wxAuth(HttpServletResponse response) throws IOException {
		String backUrl = "http://yale-dev.s1.natapp.cc/callback";
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + configuration.getAppId() + "&redirect_uri="
				+ URLEncoder.encode(backUrl, "utf-8") + "&response_type=code" + "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		response.sendRedirect(url);
	}

	/**
	 * @Title: wxCallback
	 * @Description: 通过code换取网页授权access_token 通过access_token openid 拉取用户信息(需scope为 snsapi_userinfo)
	 * @param request
	 * @return 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public RespMessage wxCallback(HttpServletRequest request) {
		
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + configuration.getAppId() + "&secret="
				+ configuration.getAppSecret() + "&code=" + code + "&grant_type=authorization_code";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new WxMessageConverter());
		AccessTokenVo accessTokenVo = restTemplate.getForObject(url, AccessTokenVo.class);
		String openid = accessTokenVo.getOpenid();
		String access_token = accessTokenVo.getAccess_token();
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid
				+ "&lang=zh_CN";
		UserInfoVo userInfoVo = restTemplate.getForObject(infoUrl, UserInfoVo.class);
		System.out.println(userInfoVo.toString());
		return RespMessage.success();
	}
}
