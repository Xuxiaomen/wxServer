package ai.yale.wxserver.vo;

public class QRCodeRequestVo {
	private Long expire_seconds;
	private String action_name;
	private ActionInfoVo action_info;
	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public ActionInfoVo getAction_info() {
		return action_info;
	}
	public void setAction_info(ActionInfoVo action_info) {
		this.action_info = action_info;
	}
	@Override
	public String toString() {
		return "QRCodeRequestVo [expire_seconds=" + expire_seconds + ", action_name=" + action_name + ", action_info="
				+ action_info + "]";
	}
	
	
}
