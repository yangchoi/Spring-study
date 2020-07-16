package sample05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
//sunbjukdto를 prototype으로 잡아주기 
// 어노테이션으로 인해 생성되는 것이기 때문에 xml은 안읽는다. >> 쓸필요 없음 

public class SungJukDTO2 {
	private String name;
	private int kor;
	private int eng;
	private int math;
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
