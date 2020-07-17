package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통관심사항
//Aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
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
















