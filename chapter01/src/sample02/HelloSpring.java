package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBean = new MessageBeanKo(); // 1:1 관계 , 결합도 100%
		MessageBean messageBean = new MessageBeanKo(); // 부모가 자식을 참조하라 (다형성)
		// 결합도를 낮춘 것
		messageBean.sayHello("Spring");

	}

}
