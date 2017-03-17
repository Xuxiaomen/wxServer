package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtil;
import ai.yale.wxserver.vo.QRCodeTicketVo;
import ai.yale.wxserver.vo.SceneVo;
import ai.yale.wxserver.vo.ActionInfoVo;
import ai.yale.wxserver.vo.QRCodeRequestVo;
import ai.yale.wxserver.vo.QRCodeResultVo;

@Service
public class AccountService {
	/**
	 *创建二维码ticket
	 * @param vo
	 * @return
	 */
	@Autowired
	WxService wxService;
	
	public QRCodeResultVo qrCodeResultVo;
	
//	public RespMessage creatQRCodeTicket() {
//		if (qrCodeTicketVo == null || "".equals(qrCodeTicketVo.getTicket())) {
//			return RespMessage.error("服务器暂时未获取qr_code_ticket，请稍后再试");
//		} else {
//			return RespMessage.success(qrCodeTicketVo);
//		}
//	}
	
	
	
	public RespMessage creatQRCode() {
		if (qrCodeResultVo != null && !qrCodeResultVo.getQRCodeImageUrl().equals("")) {
			return RespMessage.success(qrCodeResultVo);
		}
		QRCodeRequestVo requestVo = new QRCodeRequestVo();
//		创建临时二维码需要expire_seconds
//		requestVo.setExpire_seconds(604800L);
//		requestVo.setAction_name("QR_SCENE");
//		创建永久二维码
		requestVo.setAction_name("QR_LIMIT_SCENE");
		SceneVo sceneVo = new SceneVo();
		sceneVo.setScene_id(100L);
		ActionInfoVo actionInfoVo = new ActionInfoVo();
		actionInfoVo.setScene(sceneVo);
		requestVo.setAction_info(actionInfoVo);
		QRCodeTicketVo qrCodeTicketVo = WxUtil.createQRCodeTicket(wxService.accessTokenVo.getAccess_token(), requestVo);
		String ImageUrl = WxUtil.CREATE_QRCODEIMAGE_URL.replace("TICKET", qrCodeTicketVo.getTicket());
		qrCodeResultVo = new QRCodeResultVo();
		qrCodeResultVo.setQRCodeImageUrl(ImageUrl);
		qrCodeResultVo.setQRCodeLinkUrl(qrCodeTicketVo.getUrl());
		return RespMessage.success(qrCodeResultVo);
	}
}
