package sample03;

public class MessageBeanKo implements MessageBean{
	private int num; 
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자");
	}
	
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num= " + num);
		System.out.println("안녕하세요, "+ name + "!");
		
	}

}
