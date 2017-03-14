package ai.yale.wxserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.MenuService;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.vo.MenuJsonVo;

/**
 * 微信菜单
 * @author lvjia
 *
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;

	/**
	 * 创建公众号菜单
	 * @param input
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public RespMessage createMenu(MenuJsonVo vo) {
		return menuService.createMenu(vo);
	}
}
