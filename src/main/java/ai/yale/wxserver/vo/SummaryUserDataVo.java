package ai.yale.wxserver.vo;

/**
 *  用户分析数据接口增减用户数据
 * @author 徐梦
 *
 */
public class SummaryUserDataVo {
	private String ref_date;
	private int user_source;
	private int new_user;
	private int cancel_user;
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	public int getUser_source() {
		return user_source;
	}
	public void setUser_source(int user_source) {
		this.user_source = user_source;
	}
	public int getNew_user() {
		return new_user;
	}
	public void setNew_user(int new_user) {
		this.new_user = new_user;
	}
	public int getCancel_user() {
		return cancel_user;
	}
	public void setCancel_user(int cancel_user) {
		this.cancel_user = cancel_user;
	}
	@Override
	public String toString() {
		return "IncreaseAndDecreaseUserDataVo [ref_date=" + ref_date + ", user_source=" + user_source + ", new_user="
				+ new_user + ", cancel_user=" + cancel_user + "]";
	}
}
