package ai.yale.wxserver.vo;

public class DateVo {
	private String begin_date;
	private String end_date;
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "DateVo [begin_date=" + begin_date + ", end_date=" + end_date + "]";
	}
}
