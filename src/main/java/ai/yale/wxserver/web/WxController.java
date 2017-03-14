package ai.yale.wxserver.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.WxAuthService;
import ai.yale.wxserver.service.WxService;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.vo.WxVo;

@RestController
public class WxController {

	@Autowired
	WxService wxService;

	@Autowired
	WxAuthService wxAuthService;

	/**
	 * 接收微信配置请求
	 * 
	 * @param vo
	 * @return echostr
	 */
	@RequestMapping(value = "/weixin", method = RequestMethod.GET)
	@ResponseBody
	public String wxConfig(WxVo vo) {
		return wxService.wxConfig(vo);
	}

	/**
	 * 接收微信统一消息
	 * 
	 * @param request
	 * @return string
	 */
	@RequestMapping(value = "/weixin", method = RequestMethod.POST)
	@ResponseBody
	public String wxMessage(HttpServletRequest request) {
		return wxService.wxMessage(request);
	}

	/**
	 * 获取微信access token
	 * 
	 * @return RespMessage
	 */
	@RequestMapping(value = "/access_token", method = RequestMethod.GET)
	@ResponseBody
	public RespMessage accessToken() {
		return wxService.wxAccessToken();
	}

	/**
	 * 跳转到微信认证页面
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/auth")
	public void wxAuth(HttpServletResponse response) throws IOException {
		// ...
		wxAuthService.wxAuth(response);
	}

	/**
	 * 跳转到微信认证页面
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/callback")
	public RespMessage wxCallback(HttpServletRequest request) throws ClientProtocolException, IOException {

		return wxAuthService.wxCallback(request);
	}

}
