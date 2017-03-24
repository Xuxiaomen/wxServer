package ai.yale.wxserver.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.JssdkService;
import ai.yale.wxserver.util.RespMessage;

/**
 * JS-SDK使用权限签名算法
 * @author 徐梦
 */
@RestController
@RequestMapping(value = "/jssdk")
public class JssdkController {

	@Autowired
	JssdkService jssdkService;

	/**
	 * 获取jssdk signature
	 * @return
	 */
	@RequestMapping(value = "/signature", method = RequestMethod.GET)
	@ResponseBody
	public RespMessage wxJsapiSignature(HttpServletRequest request) {
		return jssdkService.wxJsapiSignature(request);
	}

}
