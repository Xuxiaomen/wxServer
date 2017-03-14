package ai.yale.wxserver.vo;

public class AccessTokenVo {

	private String access_token;
	private Long expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		return "AccessTokenVo [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}
	
	
}
