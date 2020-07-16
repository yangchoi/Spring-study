package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	private int x;
	private int y;
	
	// setter
	@Autowired
	// autowired 자동으로 필요로 할 때 값이 주입된다. 
	public void setX(@Value("25")int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("36")int y) {
		this.y = y;
	}
// 생성자는 new 하는 시점에서 자동으로 호출되어서 25, 36 과 같은 값이 적용되지만
// setter의 경우에는 따로 호출해주지 않으면 호출되지 않는다.

	@Override
	public void calculate() {
		System.out.println(x + "+" + y + "=" + (x * y));

	}

}
