package ai.yale.wxserver.service;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import ai.yale.wxserver.util.LogHelper;

/**
 * 切面编程类
 * @author 徐梦
 *
 */
@Aspect
@Component
public class AopService {

	@AfterReturning(value = "execution(* ai.yale.wxserver.util.WxUtils.*(..))", argNames = "retValue", returning = "retValue")
	public void aspectMethod(JoinPoint joinPoint, Object retValue) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		LogHelper.log(LogHelper.INFO_INT, method.getName() + ": " + retValue.toString());
		
	}
}
