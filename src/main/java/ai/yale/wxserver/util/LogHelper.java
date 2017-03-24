package ai.yale.wxserver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * logger信息辅助类
 * @author 徐梦
 *
 */
public class LogHelper {
	private final static Logger logger = LoggerFactory.getLogger(LogHelper.class);

	public static final int OFF_INT = Integer.MAX_VALUE;
	public static final int ERROR_INT = 40000;
	public static final int WARN_INT = 30000;
	public static final int INFO_INT = 20000;
	public static final int DEBUG_INT = 10000;
	public static final int TRACE_INT = 5000;
	public static final int ALL_INT = Integer.MIN_VALUE;

	public static void log(int level, String output) {
		
		switch (level) {
		case INFO_INT:
			logger.info(output);
			break;
		case DEBUG_INT:
			logger.debug(output);
			break;
		case WARN_INT:
			logger.warn(output);
			break;
		case ERROR_INT:
			logger.error(output);
			break;
		case TRACE_INT:
			logger.trace(output);
			break;
		case ALL_INT:
			logger.debug(output);
			break;
		default:
			break;
			
		}
	}
}
