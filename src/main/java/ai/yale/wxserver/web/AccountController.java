package ai.yale.wxserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.AccountService;
import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.vo.QRCodeTicketVo;

/**
 * 获取微信二维码
 * @author 徐梦
 *
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

public QRCodeTicketVo qrCodeTicketVo;
	@Autowired 
	AccountService accountService;
	
	@RequestMapping(value = "/create_qrcode_ticket")
	public RespMessage createQRCode() {
		
		return accountService.creatQRCode();
	}
}
