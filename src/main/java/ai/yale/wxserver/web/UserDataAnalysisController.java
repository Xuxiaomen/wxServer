package ai.yale.wxserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.yale.wxserver.service.UserDataAnalysisService;
import ai.yale.wxserver.util.RespMessage;


@RestController
@RequestMapping(value = "/userdata")
public class UserDataAnalysisController {
	
	@Autowired
	UserDataAnalysisService userDataAnalysisService;
	
	@RequestMapping(value = "/summary")
	@ResponseBody
	public RespMessage getusersummary() {
		return userDataAnalysisService.getusersummary();
	} 
	
	@RequestMapping(value = "/accumulated")
	@ResponseBody
	public RespMessage getusercumulate() {
		return userDataAnalysisService.getusercumulate();
	} 
}
