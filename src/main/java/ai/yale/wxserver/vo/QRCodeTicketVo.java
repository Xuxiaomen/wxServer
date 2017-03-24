package ai.yale.wxserver.vo;

/**
 * 创建二维码ticket时返回的参数
 * @author 徐梦
 *
 */
public class QRCodeTicketVo {
	private String ticket;
	private Long expire_seconds;
	private String url;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "QRCodeTicketVo [ticket=" + ticket + ", expire_seconds=" + expire_seconds + ", url=" + url + "]";
	}
}
