package ai.yale.wxserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yale.wxserver.util.RespMessage;
import ai.yale.wxserver.util.WxUtils;
import ai.yale.wxserver.vo.AccumulatedUserDataVo;
import ai.yale.wxserver.vo.DateVo;
import ai.yale.wxserver.vo.SummaryUserDataVo;

/**
 * @Title: UserDataAnalysisService
 * @Description: 用户分析数据接口实现
 * @author 徐梦
 *
 */
@Service
public class UserDataAnalysisService {

	@Autowired
	WxService wxService;

	@Autowired
	WxUtils wxUtils;

	/**
	 * 获取用户增减数据接口的返回JSON数据
	 * 
	 * @return summaryUserDataVo
	 */
	public RespMessage getusersummary() {

		DateVo dateVo = new DateVo();
		dateVo.setBegin_date("2017-03-20");
		dateVo.setEnd_date("2017-03-21");
		SummaryUserDataVo summaryUserDataVo = wxUtils.userDataSummary(wxService.accessTokenVo.getAccess_token(), dateVo);
		return RespMessage.success(summaryUserDataVo);

	}

	/**
	 * 获取累计用户数据接口的返回JSON数据
	 * 
	 * @return accumulatedUserDataVo
	 */
	public RespMessage getusercumulate() {

		DateVo dateVo = new DateVo();
		dateVo.setBegin_date("2017-03-17");
		dateVo.setEnd_date("2016-03-23");
		AccumulatedUserDataVo accumulatedUserDataVo = wxUtils.userDateAccumulated(wxService.accessTokenVo.getAccess_token(), dateVo);
		return RespMessage.success(accumulatedUserDataVo);

	}
}
