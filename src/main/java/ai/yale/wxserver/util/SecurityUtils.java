package ai.yale.wxserver.util;

import java.security.MessageDigest;
import java.util.Formatter;

/**
 * 对字符串进行加密解密公共库
 * @author xumeng
 *
 */
public class SecurityUtils {

	/**
	 * 对字符串sha1加密
	 * 
	 * @param src
	 * @return
	 */
	public static String SHA1(String src) {
		String result = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(src.getBytes("UTF-8"));
			result = byteToHex(crypt.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
}
