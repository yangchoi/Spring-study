package sample04;

public class MessageBeanImpl implements MessageBean{
	private String name; 
	private String phone;
	private Outputter outputter;
	
	public MessageBeanImpl(String name) {
		System.out.println("1. MessageBeanImpl 생성자");
		this.name = name;
	}
	// 참조한 fileoutputter 갔다가 다 처리되면 다시 돌아온다.
	public void setPhone(String phone) {
		System.out.println("5. setPhone(String phone)");
		this.phone = phone;
	}

	public void setOutputter(Outputter outputter) {
		System.out.println("6. setOutputter(Outputter outputter)");
		this.outputter = outputter;
	}

	@Override
	public void helloCall() {
		System.out.println("7. helloCall()");
		outputter.output("이름 = " + name + ", 핸드폰 = " + phone); // 파일로 출력
		// 파일로 들어간다. 
	}
	
}
