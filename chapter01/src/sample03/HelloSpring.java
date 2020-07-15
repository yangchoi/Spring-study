package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
				// 인터페이스이기 때문에 직접적인 new 불가
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean bean = (MessageBean)context.getBean("messageBean"); // 부모가 받아야 en 이든 ko든 다 받을 수 있다.
		bean.sayHello("Spring");
		
		MessageBean bean2 = context.getBean("messageBean", MessageBean.class); // 부모가 받아야 en 이든 ko든 다 받을 수 있다.
		// 캐스팅 대신 MessageBean.class로 잡아줄 수 있다. (MessageBean 클래스 형태로 잡겠다는 뜻, 클래스 타입을 설정해버리는 것이다.)
		bean2.sayHello("Spring");
		
		MessageBean bean3 = (MessageBean)context.getBean("messageBean"); // 부모가 받아야 en 이든 ko든 다 받을 수 있다.
		bean3.sayHello("Spring");
		
		// 1, 1, 1이 아닌 1, 2, 3으로 나온다. 
		// 값이 각자 잡힌게 아니라 하나 잡힌 것이다. 
		// Java에서 하나만 잡힌 것 : 싱글톤 
		// Spring은 기본이 new 생성이 아닌 싱글톤이다. 
		// 하지만 만약 따로 잡히길 원한다면 context.xml로 가서 scope를 prototype으로 잡는다.
		
		
	}

}
