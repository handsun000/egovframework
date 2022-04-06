package egov.lib.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ExampleAOP {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleAOP.class);
	
	@Pointcut("execution(* egov.**.web.*Controller.*(..))") //@Pointcut("within(egov.main.web.*)")
	public void themeMethod() {
		
	}
	
	@Before("themeMethod()")
	public void beforeMethod(JoinPoint joinpoint) throws Exception{
		
		System.out.println("사용자의 요청 " + joinpoint.getTarget());
		logger.info("사용자의 요청 " + joinpoint.getTarget());
		
	}
	
	@AfterThrowing(pointcut = "themeMethod()", throwing = "exception")
	public void exceptionMethod(JoinPoint joinPoint, Exception exception) throws Exception{
		logger.error("ST에러발생=================");
		logger.error("에러위치:" + exception.getClass());
		logger.error("에러내용:" + exception.getMessage());
		logger.error("ED에러발생=================");
	}
	
	@After("themeMethod()")
	public void afterMethod() throws Exception {
		logger.info("메소드 종료");
	}
	
	@Around("themeMethod()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//시간
		long st = System.currentTimeMillis();
		//핵심기능
		Object rtn = joinPoint.proceed();
		//시간
		long ed = System.currentTimeMillis();
		
		logger.info("걸린시간: " + (ed-st));
		return rtn;
	}

}
