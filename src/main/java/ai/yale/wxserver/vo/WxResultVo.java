package ai.yale.wxserver.vo;

/**
 * 微信统一返回消息
 * @author lvjia
 *
 */
public class WxResultVo {
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
		return "WxResultVo [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
	
}
