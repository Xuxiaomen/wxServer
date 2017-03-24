package ai.yale.wxserver.vo;

/**
 * 用户分析数据接口累计用户数据
 * @author 徐梦
 *
 */
public class AccumulatedUserDataVo {
	private String ref_date;
	private int cumulate_user;
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	public int getCumulate_user() {
		return cumulate_user;
	}
	public void setCumulate_user(int cumulate_user) {
		this.cumulate_user = cumulate_user;
	}
	@Override
	public String toString() {
		return "AccumulatedUserDataVo [ref_date=" + ref_date + ", cumulate_user=" + cumulate_user + "]";
	}
}
