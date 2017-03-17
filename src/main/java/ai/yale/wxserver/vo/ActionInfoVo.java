package ai.yale.wxserver.vo;

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
