package ai.yale.wxserver.bean;

/**
 * 文本消息类
 * @author 吕佳
 *
 */
public class TextMessage extends BaseMessage {
	private String Content;
	private Long MsgId;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
	
	
}
