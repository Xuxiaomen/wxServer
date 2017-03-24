package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.MenuJsonVo;
import ai.yale.wxserver.vo.WxResultVo;

/**
 * 微信菜单服务
 * @author lvjia
 *
 */
@Service
public class MenuService {

	@Autowired
	WxService wxService;
	
	@Autowired
	WxUtils wxUtils;
	
	public RespMessage createMenu(MenuJsonVo vo) {
		
		WxResultVo result = wxUtils.createMenu(wxService.accessTokenVo.getAccess_token(), vo.getMenuJson());
		if (result.getErrcode() == 0) {
			return RespMessage.success();
		}
		return RespMessage.error();
		
	}
}
