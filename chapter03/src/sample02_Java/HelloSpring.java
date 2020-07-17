package sample02_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloSpring {
	public static void main(String[] args) {
		MessageBean messageBean = new MessageBeanImpl();
		
		MessageBean proxy = (MessageBean) Proxy.newProxyInstance(
				MessageBeanImpl.class.getClassLoader(),
				new Class[] {MessageBean.class },
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("입실 체크한다");//공통
						
						Object ob = method.invoke(messageBean, args);
						
						System.out.println("퇴실 체크한다");//공통
						return ob;
					}
				});
		
		proxy.study();
		System.out.println("-----------");
		System.out.println("결과 = "+proxy.game());
	}
}















