package ai.yale.wxserver.vo;

public class LinkRespMessageVo extends WxBaseRespMessageVo{
	private String short_url;

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

	@Override
	public String toString() {
		return "LinkRespMessageVo [short_url=" + short_url + "]";
	}
}
