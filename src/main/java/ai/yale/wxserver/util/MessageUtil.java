package ai.yale.wxserver.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import ai.yale.wxserver.bean.Article;
import ai.yale.wxserver.bean.NewsMessage;
import ai.yale.wxserver.bean.TextMessage;
import ai.yale.wxserver.vo.FaqRobotTextMessageReplyVo;

public class MessageUtil {
	
	/**
	 * 转换inputStream 到 map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> streamToMap(InputStream inputStream){
		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		
		Document document;
		try {
			document = reader.read(inputStream);
			Element root = document.getRootElement();
			
			List<Element> list = root.elements();
			
			for (Element element : list) {
				map.put(element.getName(), element.getText());
			}
		
			return map;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 文本消息转换xml
	 * @param message
	 * @return
	 */
	public static String textMessageToXml(TextMessage message) {
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		return xStream.toXML(message);
	}
	
	/**
	 * 图文消息转换xml
	 * @param message
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage message) {
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		xStream.alias("item", (new Article()).getClass());		
		return xStream.toXML(message);
	}
	
	/**
	 * 云问文本消息转换xml
	 * @param message
	 * @return
	 */
	public static String newsMessageToXml(FaqRobotTextMessageReplyVo result) {
		XStream xStream = new XStream();
		xStream.alias("xml", result.getClass());
		xStream.alias("item", (new Article()).getClass());		
		return xStream.toXML(result);
	}
}
