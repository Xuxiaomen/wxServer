package ai.yale.wxserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.LinkService;
import ai.yale.wxserver.util.RespMessage;

/**
 * 微信长链接转短链接
 * @author 徐梦
 *
 */
@RestController
@RequestMapping(value="/link")
public class LinkCotroller {
	
	@Autowired
	LinkService linkService;
	@RequestMapping(value="/long_to_short")
	public RespMessage linkLongToShort() {
		return linkService.linkLongToShort();
	}
}
