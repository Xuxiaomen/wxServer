package ai.yale.wxserver.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.WxFaqRobotService;

@RestController

public class WxFaqRobotController {

	@ResponseBody
	@RequestMapping(value="")
	public String wxMessage(HttpServletRequest request) {
		return WxFaqRobotService.wxFaqRobotMessage(request);
	}
}
