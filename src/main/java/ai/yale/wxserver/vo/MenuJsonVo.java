package ai.yale.wxserver.vo;

/**
 * 自定义菜单post的json数据
 * @author 徐梦
 *
 */
public class MenuJsonVo {
	private String menuJson;

	public String getMenuJson() {
		return menuJson;
	}

	public void setMenuJson(String menuJson) {
		this.menuJson = menuJson;
	}

	@Override
	public String toString() {
		return "MenuJsonVo [menuJson=" + menuJson + "]";
	}
	
	
}
