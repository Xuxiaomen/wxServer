package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.LinkRespMessageVo;
import ai.yale.wxserver.vo.LongLinkToShortLinkVo;

/**
 * @Title: LinkService
 * @Description: 长链转短链接口实现
 * @author 徐梦
 *
 */
@Service
public class LinkService {

	@Autowired
	WxService wxService;
	
	@Autowired
	WxUtils wxUtils;
	
	public RespMessage linkLongToShort() {
		
		LongLinkToShortLinkVo longLinkToShortLinkVo = new LongLinkToShortLinkVo();
		longLinkToShortLinkVo.setAction("long2short");
		longLinkToShortLinkVo.setLong_url("http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1");
		LinkRespMessageVo vo = wxUtils.linkLongToShort(wxService.accessTokenVo.getAccess_token(), longLinkToShortLinkVo);
		return RespMessage.success(vo);
		
	}
}
