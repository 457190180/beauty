package com.yimew.config.aspect;

import com.yimew.dao.sys.UserDao;
import com.yimew.entity.sys.BusinessLog;
import com.yimew.entity.sys.Log;
import com.yimew.entity.sys.LogConstants;
import com.yimew.entity.sys.User;
import com.yimew.service.sys.LogService;
import com.yimew.service.sys.impl.LogServiceImpl;
import com.yimew.util.UUIDUtils;
import com.yimew.util.UserUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 用于记录调用service层日志
 */
@Aspect
@Component
public class BusinessLogAspect {
	private static Logger logger = LoggerFactory.getLogger(BusinessLogAspect.class);

	@Autowired
	private LogService logService;

	@Autowired
	private UserDao userDao;

	@Value("${sysLogType}")
	private String sysLogType;

	/**
	 * 匹配Service层的save, update, delete, get, find, page等方法
	 */
	@Pointcut(value = "(execution(* com.yimew.service.*.*.insert*(..)) "
			+ "|| execution(* com.yimew.service.*.update*(..)) "
			+ "|| execution(* com.yimew.service.*.delete*(..)) " + "|| execution(* com.yimew.*.service.*.get*(..)) "
			+ "|| execution(* com.yimew.service.*.find*(..)) " + "|| execution(* com.yimew.*.service.*.page*(..))) "
			+ "&& !execution(* com.yimew.service.sys.LogService.*(..))")
	private void servicePointcut() {
	}

	@Around(value = "servicePointcut()")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


		Class cls = joinPoint.getTarget().getClass();
		String signature = joinPoint.getSignature().getName();
		Object result;
		// 调用service层开始时间
		long startTime = System.currentTimeMillis();
		result = joinPoint.proceed();
		// 调用service层结束时间
		long endTime = System.currentTimeMillis();
		// dev模式下不记系统日志
		if (LogConstants.LOG_TYPE_DEV.equalsIgnoreCase(sysLogType)) {
			return result;
		}

		//TODO 重要!!!!请自行实现UserUtils中获取用户id方法
		String userId = getUserId(request);
		// 非登录模式下不记系统日志
		if (userId == null) {
			return result;
		}
		logger.debug("业务日志组件开始工作");
		if (LogConstants.LOG_TYPE_SYS.equalsIgnoreCase(sysLogType)) {
			writeLog(cls.getName(), signature, null, userId, startTime, endTime);
		} else {
			for (Method method : cls.getDeclaredMethods()) {
				BusinessLog logAnnotation = (BusinessLog) method.getAnnotation(BusinessLog.class);
				if (logAnnotation != null) {
					String methodName = method.getName();
					if (signature.equals(methodName)) {
						writeLog(cls.getName(), signature, logAnnotation.description(), userId, startTime, endTime);
					}
				}
			}
		}
		logger.debug("业务日志组件工作结束");
		return result;
	}

	private String getUserId(HttpServletRequest request){
		return "test";
	}

	private void writeLog(String className, String methodName, String logAnnotation, String userId, long startTime, long endTime) throws Exception {
		Log logEO = new Log();
		//logEO.setLogId(UUIDUtils.getUUID());
		logEO.setClassname(className);
		//logEO.setMethod(methodName);
		if (logAnnotation != null && !"".equals(logAnnotation)) {
			logEO.setContent(logAnnotation);
		}
		logEO.setUserId(userId);
		//User userEO = userDao.selectByPrimaryKey(userId);
//		if (userEO != null) {
//			logEO.setUserId("");
//		}
		logEO.setCreateTime(new Date(startTime));
		logEO.setCreateTime(new Date(endTime));
		logService.insertSelective(logEO,new User());
	}
}