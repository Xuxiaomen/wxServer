package ai.yale.wxserver.vo;

public class JsapiTicketVo extends WxBaseRespMessageVo{
	private String ticket;
	private Long expiers_in;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getExpiers_in() {
		return expiers_in;
	}
	public void setExpiers_in(Long expiers_in) {
		this.expiers_in = expiers_in;
	}
	@Override
	public String toString() {
		return "JsapiTicketVo [ticket=" + ticket + ", expiers_in=" + expiers_in + "]";
	}

}
