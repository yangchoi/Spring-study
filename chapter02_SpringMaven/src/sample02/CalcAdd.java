package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("calcAdd")
//calcAdd 써도 그만 안써도 그만 (자동으로 잡아줌)
public class CalcAdd implements Calc {
	private int x;
	private int y;

	// 생성자 

	public CalcAdd(@Value("25")int x, @Value("36")int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x + "+" + y + "=" + (x+y));

	}

}
