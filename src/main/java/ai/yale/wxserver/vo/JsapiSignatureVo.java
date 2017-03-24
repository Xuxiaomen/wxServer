package ai.yale.wxserver.vo;

/**
 * JS-SDK权限签名算法所需参数
 * @author 徐梦
 *
 */
public class JsapiSignatureVo {
	private String appId;
	private Long timestamp;
	private String nonceStr;
	private String signature;
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "TicketVo [appId=" + appId + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature="
				+ signature + "]";
	}
}
