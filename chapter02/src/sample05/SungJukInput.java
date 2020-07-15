package sample05;

import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk {
	private SungJukDTO2 sungJukDTO2;
	private List<SungJukDTO2> list;
	
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}

	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}
	
	//xml에서 메모리에 선언한 dto를 settter를 통해서 가져온다. 
	// 이렇게 하는 이유는
	// 각 클래스 간의 의존도를 낮추기 위해서이다. 
	// 하나의 값이 바뀌었을 때 변경해야하는 부분을 최대한 줄여야하기 때문. 
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어점수 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scanner.nextInt();
			
		sungJukDTO2.setName(name);      
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(sungJukDTO2.getKor() + sungJukDTO2.getEng() + sungJukDTO2.getMath());
		sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);
		
		// 데이터가 입력되면 list 안에 쌓여야한다. 
		// xml에다 선언한다. 
		list.add(sungJukDTO2);
		   
		System.out.println(sungJukDTO2.getName() + "님의 데이터를 입력 하였습니다.");
	}

}


















