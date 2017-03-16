package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtil;
import ai.yale.wxserver.vo.JsapiTicketVo;
import ai.yale.wxserver.vo.JsapiSignatureVo;

@Service
public class JssdkService {
	public JsapiTicketVo jsapiTicketVo;
	
	@Autowired
	WxService wxService;
	
	/**
	 * JS-SDK使用权限签名算法
	 * @return signatureVo
	 */
	
	public RespMessage wxJsapiSignature() {
		// 获取access_token
		String accessToken = wxService.accessTokenVo.getAccess_token();
		JsapiTicketVo vo = WxUtil.getJsapiTicket(accessToken);
		
		JsapiSignatureVo signatureVo = WxUtil.getJsapiSignature(vo.getTicket());
		
		return RespMessage.success(signatureVo);	
	}
}
