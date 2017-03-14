package ai.yale.wxserver.util;

public class RespMessage {
	// 操作状态码 0：操作失败 1：操作成功 其他：自定义
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int DATA_VALIDATION_ERROR = -1;
	public static final int LOGIN_TIMEOUT = -10000;

	/** 操作状态码 **/
	private int code = SUCCESS;
	/** 返回的消息 **/
	private String msg = "操作成功";
	/** 返回的数据 **/
	private Object data;
	
	public RespMessage(){
	}
	
	public RespMessage(int code){
		this.code = code;
	}
	
	public RespMessage(Object data){
		this.data = data;
	}
	
	public RespMessage(int code, Object data){
		this.code = code;
		this.data = data;
	}
	
	public RespMessage(String msg, Object data){
		this.msg = msg;
		this.data = data;
	}
	
	public RespMessage(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public RespMessage(int code, String msg, Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static RespMessage success(){		
		return new RespMessage();
	}
	
	public static RespMessage success(Object data){		
		return new RespMessage(data);
	}
	
	public static RespMessage error(){
		return new RespMessage(FAIL, "操作失败");
	}
	
	public static RespMessage error(String msg){
		return new RespMessage(FAIL, msg);
	}
	
	public static RespMessage error(Object data){
		return new RespMessage(FAIL, data);
	}
	
	public static RespMessage error(String msg, Object data){
		return new RespMessage(FAIL, msg, data);
	}
	
	public static RespMessage timeout(Object data){
		return new RespMessage(LOGIN_TIMEOUT, "业务逻辑出错", data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
