package ai.yale.wxserver.vo;

public class JsapiTicketVo extends WxBaseRespMessageVo{
	private String ticket;
	private Long expires_in;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		return "JsapiTicketVo [ticket=" + ticket + ", expires_in=" + expires_in + "]";
	}

}
