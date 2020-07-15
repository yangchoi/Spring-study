package sample03;

import java.util.Scanner;

import lombok.AllArgsConstructor;

// 값을 impl에다 설정해서 dto로 다시 보내주고 다시 받으면 안되나? 
// 그냥 dto로 해놓은 다음에 dto에서 끌거오는게 맞지? 
// > dto에서 또 xml 값을 가져왔어야했다...

@AllArgsConstructor
//ALL을 통해 생성자를 가져온다(DTO 값을 얻는다)
// 어노테이션으로 안하려면 생성자로 DTO를 둘러오면 된다. 
public class SungJukImpl implements SungJuk{
	// 필드값 잡을 필요 없다. 
	// dto 하나만 잡으면 된다. 
	private SungJukDTO sungJukDTO;
	// 근데 new는 안잡는다. 
	// 이런 일은 전부 spring에게 의존한다. 
	// 그러려면 APPLICATION에 가서 sungJukImpl을 생성해주어야한다. 

	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO);
		
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		sungJukDTO.setName(scan.next());
		System.out.print("국어 점수 : ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.print("영어 점수 : ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.print("수학 점수 : ");
		sungJukDTO.setMath(scan.nextInt());
	}
	
	
}
