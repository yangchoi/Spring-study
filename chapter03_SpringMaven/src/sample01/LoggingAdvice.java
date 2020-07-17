package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통관심사항
//Aspect
@Aspect
//@Component
@ComponentScan("spring.conf")
public class LoggingAdvice {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before(..) )")
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = "+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		Object ob = joinPoint.proceed();//핵심관심사항 호출
		System.out.println("결과 ob = "+ob);
		
		sw.stop();
		System.out.println("처리 시간 = "+sw.getTotalTimeMillis()/1000+"초");
	}
}
















