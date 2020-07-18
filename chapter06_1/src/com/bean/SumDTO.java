package com.bean;

import lombok.Data;

@Data
public class SumDTO {
	private int x;
	private int y;
	// 만약 여기에 PRIVATE INT Z 를 선언해도 여기에는 값이 들어오지 않는다. 
	// 같은 이름의 값만 들어온다. 
}
