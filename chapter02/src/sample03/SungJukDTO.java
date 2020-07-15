package sample03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SungJukDTO {
	String name;
	int kor; 
	int eng; 
	int math; 
	int tot;
	double avg;
	
	@Override
	//객체 주소값을 읽어내는 toString
	// 이렇게 값을 불러온다. 
	public String toString() {
		return name + "\t"
				+ kor + "\t"
				+ eng + "\t"
				+ math + "\t"
				+ tot + "\t"
				+ String.format("%.2f", avg);
	}
}
