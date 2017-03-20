package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtil;
import ai.yale.wxserver.vo.AccumulatedUserDataVo;
import ai.yale.wxserver.vo.DateVo;
import ai.yale.wxserver.vo.SummaryUserDataVo;

@Service
public class UserDataAnalysisService {

	@Autowired
	WxService wxService;

	@Autowired
	WxUtil wxUtil;

	/**
	 * 获取用户增减数据接口的返回JSON数据
	 * 
	 * @return summaryUserDataVo
	 */
	public RespMessage getusersummary() {

		DateVo dateVo = new DateVo();
		dateVo.setBegin_date("2014-12-02");
		dateVo.setEnd_date("2014-12-07");
		SummaryUserDataVo summaryUserDataVo = wxUtil.userDataSummary(wxService.accessTokenVo.getAccess_token(), dateVo);
		return RespMessage.success(summaryUserDataVo);

	}

	/**
	 * 获取累计用户数据接口的返回JSON数据
	 * 
	 * @return accumulatedUserDataVo
	 */
	public RespMessage getusercumulate() {

		DateVo dateVo = new DateVo();
		dateVo.setBegin_date("2014-12-02");
		dateVo.setEnd_date("2014-12-07");
		AccumulatedUserDataVo accumulatedUserDataVo = wxUtil.userDateAccumulated(wxService.accessTokenVo.getAccess_token(), dateVo);
		return RespMessage.success(accumulatedUserDataVo);

	}
}
