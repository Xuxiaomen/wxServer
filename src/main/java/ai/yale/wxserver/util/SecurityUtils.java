package ai.yale.wxserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * 对字符串进行加密解密公共库
 * @author 徐梦
 *
 */
public class SecurityUtils {

	/**
	 * 对字符串sha1加密
	 * 
	 * @param src
	 * @return String
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
	
	/**
	 * 对字符串MD5加密
	 * @param info
	 * @return String
	 */
	public static String encryptToMD5(String info) {
		
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串
        String rs = byteToHex(digesta);
        return rs;
        
    }

	/**
	 * 将二进制转化为16进制字符串
	 * @param hash 二进制字节数组
	 * @return String
	 */
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
	public static void main(String[] args) {
		String source = "hello";
		System.out.println(SHA1(source));
		System.out.println(encryptToMD5(source));
	}
}
