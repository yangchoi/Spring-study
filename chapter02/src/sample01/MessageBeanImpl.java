package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull
	private String fruit;
	// requiredArgsConstructor : 원하는 것만 생성자 만든다.  fruit를 notnull로 하라. (fruit 만 생성자 만든다) 
	@Setter
	private int cost, qty;
	
	/*
	public MessageBeanImpl(String fruit) {
		super(); // 부모생성자 불러오기
		this.fruit = fruit;
		// 기본생성자를 만들기 싫으면 값을 주면 된다. (xml에)
	}
	
	// setter

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	 */

	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

}
