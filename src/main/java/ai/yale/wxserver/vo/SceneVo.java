package ai.yale.wxserver.vo;

/**
 * 生成二维码请求参数:scene
 * @author 徐梦
 *
 */
public class SceneVo {
	private Long scene_id;

	public Long getScene_id() {
		return scene_id;
	}

	public void setScene_id(Long scene_id) {
		this.scene_id = scene_id;
	}

	@Override
	public String toString() {
		return "SceneVo [scene_id=" + scene_id + "]";
	}
	
}
