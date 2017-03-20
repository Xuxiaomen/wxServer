package ai.yale.wxserver.vo;

import ai.yale.wxserver.bean.BaseMessage;

public class FaqRobotTextMessageReplyVo extends BaseMessage{
	private String Content;
	private Long FuncFlag;
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Long getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(Long funcFlag) {
		FuncFlag = funcFlag;
	}
	@Override
	public String toString() {
		return "FaqRobotTextMessageReplyVo [Content=" + Content + ", FuncFlag=" + FuncFlag + "]";
	}
}
