package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Component
@ComponentScan("spring.conf")
public class SungJukDTO {
	private @Value("홍길동")String name;
	private @Value("97")int kor;
	private @Value("100")int eng;
	private @Value("95")int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name + "\t" 
			 + kor + "\t" 
			 + eng + "\t" 
			 + math + "\t" 
			 + tot + "\t" 
			 + String.format("%.2f", avg);
	}
}















