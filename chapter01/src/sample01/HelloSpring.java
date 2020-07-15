package sample01;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean messageBean = new MessageBean(); // 1:1 관계 
		messageBean.sayHello("Spring");

	}

}
