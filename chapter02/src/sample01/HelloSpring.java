package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBean messageBean = new MessageBeanImpl();
		// new 클래스 하면 생성자가 따라오게 된다. 
		// 디폴트는 자동으로 처리하지만, 생성자는 이미 fruit 값을 넣어서 사용하고 있다. 
		// 그렇기 때문에 기본 생성자가 없다. 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = (MessageBean)context.getBean("messageBeanImpl");
		// object 타입으로 읽어오지말고 messageBean 타입으로 읽어와라고 캐스팅 건다. 
		messageBean.sayHello();
		messageBean.sayHello("참외", 10000);
		// 갯수를 안줬기 때문에 2개로 나온다. 
		messageBean.sayHello("수박", 12000, 3);

	}

}
