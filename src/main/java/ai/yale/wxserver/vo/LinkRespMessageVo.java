package ai.yale.wxserver.vo;

/**
 * 长链接转成短链接返回的json数据包
 * @author 徐梦
 *
 */
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
