package ai.yale.wxserver.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 转换微信text/plain返回消息
 * @author 吕佳
 *
 */
public class WxMessageConverter extends MappingJackson2HttpMessageConverter {

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}
	
    public WxMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }

}
