package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	// 자동 매핍 : 타입을 찾으라. 어노테이션으로 설정된 애들을 찾아라
	@Autowired // 자동 mapping 하라 
	private SungJukDTO2 sungJukDTO2;
	
	//list가 부모이므로 여러개의 클래스가 생성될 수 있다. 
	// 그러므로 반드시 @Qualifier를 사용해서 Bean id를 등록해야한다. 
	@Qualifier("list") // bean에 list인 것을 잡아와라 
	@Autowired // @Component, @Bean 안에서 ArrayList 타입을 찾아서 수행을 한다. 
	private List<SungJukDTO2> list;
	
	// setter 잡아놓으면 xml 안읽는다. >>component 어노테이션 설정했기 때문.
	// 알아서 자동으로 mapping 해준다. 
	// 그걸 어노테이션으로 말해줘야 component 어노테이션을 찾아간다. 
	// > autowired
	// 그럼 setter 없애도 된다. 
	
	/*
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}*/
	/*
	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}
	*/

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scan.nextInt();
			
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(sungJukDTO2.getKor() + sungJukDTO2.getEng() + sungJukDTO2.getMath());
		sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);
		
		list.add(sungJukDTO2);
		   
		System.out.println(sungJukDTO2.getName() + "님의 데이터를 입력 하였습니다.");
	}

}


















