package sample03_Advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around --> 입실 체크한다");
		long start = System.currentTimeMillis();
		
		Object ob = invocation.proceed();//핵심
		
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000+"초");
		System.out.println("Around --> 퇴실 체크한다");
		return ob;
	}

}
