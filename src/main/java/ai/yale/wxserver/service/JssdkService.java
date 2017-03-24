package ai.yale.wxserver.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.JsapiTicketVo;
import ai.yale.wxserver.vo.JsapiSignatureVo;

/**
 * @Title: JssdkService
 * @Description: jssdk获取签名
 * @author 徐梦
 *
 */
@Service
public class JssdkService {
	public JsapiTicketVo jsapiTicketVo;
	
	@Autowired
	WxService wxService;
	
	@Autowired
	WxUtils wxUtils;
	
	/**
	 * JS-SDK使用权限签名算法
	 * @return signatureVo
	 */
	
	public RespMessage wxJsapiSignature(HttpServletRequest request) {
		// 获取access_token
		String accessToken = wxService.accessTokenVo.getAccess_token();
		JsapiTicketVo vo = wxUtils.getJsapiTicket(accessToken);
		JsapiSignatureVo signatureVo = wxUtils.getJsapiSignature(vo.getTicket(), request.getHeader("referer"));
		return RespMessage.success(signatureVo);
		
	}
}
