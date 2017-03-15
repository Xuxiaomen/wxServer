package ai.yale.wxserver.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import ai.yale.wxserver.bean.Article;
import ai.yale.wxserver.bean.NewsMessage;
import ai.yale.wxserver.bean.TextMessage;
import ai.yale.wxserver.vo.AccessTokenVo;
import ai.yale.wxserver.vo.JsapiSignatureVo;
import ai.yale.wxserver.vo.JsapiTicketVo;
import ai.yale.wxserver.vo.UploadTemporaryMeterialResultVo;
import ai.yale.wxserver.vo.WxResultVo;

public class WxUtil {
	public static final String TOKEN = "fgx_2017";
	// 测试号lvjia
	// public static final String APPID = "wxede20d9286db6756";
	// public static final String APPSECRET =
	// "b548de5f324a3abc9cab2d9d32c49e15";
	// 测试号xumeng
	public static final String APPID = "wx89fc0d2eadcbb2d7";
	public static final String APPSECRET = "436e89c974fe6303ada90e46e3e25ae8";
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static final String UPLOAD_TEMPRORY_METERIAL_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	// public static final String UPLOAD_METERIAL_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	// public static final String UPLOAD_NEWS_URL =
	// "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	public static final String JSSDK_URL = "http://yale-dev.s1.natapp.cc";

	/**
	 * 校验微信配置参数
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {

		String[] arr = new String[] { TOKEN, timestamp, nonce };
		Arrays.sort(arr);
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		String localSignature = SecurityUtil.SHA1(content.toString());

		return localSignature.equals(signature);
	}

	/**
	 * 接收微信消息并转储为map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> receiveMessage(HttpServletRequest request) {
		InputStream inputStream;
		try {
			inputStream = request.getInputStream();
			Map<String, String> map = MessageUtil.streamToMap(inputStream);
			inputStream.close();
			return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 生成文本回复消息
	 * 
	 * @param receivedMessage
	 * @param content
	 * @return
	 */
	public static String replyTextMessage(Map<String, String> receivedMessage, String content) {
		TextMessage reply = new TextMessage();
		reply.setToUserName(receivedMessage.get("FromUserName"));
		reply.setFromUserName(receivedMessage.get("ToUserName"));
		reply.setCreateTime((new Date()).getTime());
		reply.setMsgType(MessageUtil.MESSAGE_TEXT);
		reply.setContent(content);

		return MessageUtil.textMessageToXml(reply);
	}

	/**
	 * 生成图文回复消息
	 * 
	 * @param receivedMessage
	 * @param content
	 * @return
	 */
	public static String replyNewsMessage(Map<String, String> receivedMessage, List<Article> articles) {
		NewsMessage reply = new NewsMessage();
		reply.setToUserName(receivedMessage.get("FromUserName"));
		reply.setFromUserName(receivedMessage.get("ToUserName"));
		reply.setCreateTime((new Date()).getTime());
		reply.setMsgType(MessageUtil.MESSAGE_NEWS);
		reply.setArticleCount((long) articles.size());
		reply.setArticles(articles);

		return MessageUtil.newsMessageToXml(reply);
	}

	/**
	 * 获取AccessToken
	 * 
	 * @return AccessTokenVo
	 */
	public static AccessTokenVo getAccessToken() {
		RestTemplate restTemplate = new RestTemplate();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		AccessTokenVo vo = restTemplate.getForObject(url, AccessTokenVo.class);
		System.out.println(vo);
		return vo;
	}

	/**
	 * 上传临时文件并获取media id
	 * 
	 * @return
	 */
	public static UploadTemporaryMeterialResultVo uploadTemporaryMeterial(String accessToken, String type, File file) {
		RestTemplate restTemplate = new RestTemplate();
		String url = UPLOAD_TEMPRORY_METERIAL_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("file", fileSystemResource);
		param.add("filename", fileSystemResource.getFilename());
		try {
			param.add("filelength", fileSystemResource.contentLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		restTemplate.getMessageConverters().add(new WxMessageConverter());

		UploadTemporaryMeterialResultVo vo = restTemplate.postForObject(url, param,
				UploadTemporaryMeterialResultVo.class);
		return vo;

	}

	/**
	 * 创建微信菜单
	 * 
	 * @param accessToken
	 * @param menu
	 * @return
	 */
	public static WxResultVo createMenu(String accessToken, String menu) {
		RestTemplate restTemplate = new RestTemplate();
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		System.out.println(menu);
		JSONObject obj = JSON.parseObject(menu);
		WxResultVo vo = restTemplate.postForObject(url, obj, WxResultVo.class);
		System.out.println(vo.toString());
		return vo;
	}
	
	
	/**
	 * 获取jsapi ticket
	 * @param accessToken
	 * @return JsapiTicketVo
	 */
	public static JsapiTicketVo getJsapiTicket(String accessToken){ 
        String url = JSAPI_TICKET_URL.replace("ACCESS_TOKEN", accessToken);
        RestTemplate restTemplate = new RestTemplate();
        JsapiTicketVo vo = restTemplate.getForObject(url, JsapiTicketVo.class);
		System.out.println(vo.toString());
		return vo;
    }  
	
	/**
	 * 获取jsapi signature
	 * @param accessToken
	 * @return
	 */
	public static JsapiSignatureVo getJsapiSignature(String jsapiTicket){ 
		JsapiSignatureVo vo = new JsapiSignatureVo();
		vo.setNonceStr(UUID.randomUUID().toString());
		vo.setTimestamp(System.currentTimeMillis() / 1000);
		vo.setAppId(APPID);
		String src = "jsapi_ticket=" + jsapiTicket +
                "&noncestr=" + vo.getNonceStr() +
                "×tamp=" + vo.getTimestamp() +
                "&url=" + JSSDK_URL;
		vo.setSignature(SecurityUtil.SHA1(src));
		return vo;
    } 

}
