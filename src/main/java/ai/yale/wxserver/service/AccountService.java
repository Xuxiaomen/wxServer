package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.Configuration;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.QRCodeTicketVo;
import ai.yale.wxserver.vo.SceneVo;
import ai.yale.wxserver.vo.ActionInfoVo;
import ai.yale.wxserver.vo.QRCodeRequestVo;
import ai.yale.wxserver.vo.QRCodeResultVo;

/**
 * @Title: AccountService
 * @Description: 微信二维码获取
 * @author 徐梦
 *
 */
@Service
public class AccountService {
	/**
	 *创建二维码ticket
	 * @param vo
	 * @return
	 */
	@Autowired
	WxService wxService;
	
	@Autowired 
	Configuration configuration;
	
	@Autowired
	WxUtils wxUtils;
	
	public QRCodeResultVo qrCodeResultVo;
	
	public RespMessage creatQRCode() {
		
		if (qrCodeResultVo != null && !qrCodeResultVo.getQRCodeImageUrl().equals("")) {
			return RespMessage.success(qrCodeResultVo);
		}
		QRCodeRequestVo requestVo = new QRCodeRequestVo();
		requestVo.setAction_name("QR_LIMIT_SCENE");
		SceneVo sceneVo = new SceneVo();
		sceneVo.setScene_id(100L);
		ActionInfoVo actionInfoVo = new ActionInfoVo();
		actionInfoVo.setScene(sceneVo);
		requestVo.setAction_info(actionInfoVo);
		QRCodeTicketVo qrCodeTicketVo = wxUtils.createQRCodeTicket(wxService.accessTokenVo.getAccess_token(), requestVo);
		String ImageUrl = configuration.getCreateQrcodeimageUrl().replace("TICKET", qrCodeTicketVo.getTicket());
		qrCodeResultVo = new QRCodeResultVo();
		qrCodeResultVo.setQRCodeImageUrl(ImageUrl);
		qrCodeResultVo.setQRCodeLinkUrl(qrCodeTicketVo.getUrl());
		return RespMessage.success(qrCodeResultVo);
		
	}
}
