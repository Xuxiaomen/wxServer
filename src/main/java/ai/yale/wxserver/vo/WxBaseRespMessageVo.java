package ai.yale.wxserver.vo;

/**
 * 微信返回的JSON数据包基类
 * @author 徐梦
 *
 */
public class WxBaseRespMessageVo {
	private Long errcode;
	private String errmsg;
	public Long getErrcode() {
		return errcode;
	}
	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "WxBaseRespMessage [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
}
