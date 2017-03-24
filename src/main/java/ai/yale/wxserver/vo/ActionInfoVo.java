package ai.yale.wxserver.vo;

/**
 * 生成二维码请求参数:action_info
 * @author 徐梦
 *
 */
public class ActionInfoVo {
	private SceneVo scene;

	public SceneVo getScene() {
		return scene;
	}

	public void setScene(SceneVo scene) {
		this.scene = scene;
	}

	@Override
	public String toString() {
		return "ActionInfoVo [scene=" + scene + "]";
	}
	
}
