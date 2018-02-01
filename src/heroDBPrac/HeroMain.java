package heroDBPrac;

import java.util.ArrayList;
import java.util.Scanner;



public class HeroMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HeroDAO dao = new HeroDAO();
		while(true) {	
		System.out.println("===========================");
		System.out.println("번호를 입력하세요");
		System.out.println("1.영웅 정보 보기 ");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		System.out.println("===========================");
		int inputNum= sc.nextInt();
		if(inputNum==1) { //영웅정보 보기 
			ArrayList<HeroInfo> list = dao.getHeroInfoList();		
			//조회한 데이터 뿌리기
			System.out.println("번호	이름	힘	스피드");
			for (int i = 0; i < list.size(); i++) {
				HeroInfo ci = list.get(i);
				System.out.print(ci.getCiNum()+"	");
				System.out.print(ci.getCiName()+"	");
				System.out.print(ci.getCiFower()+"	");
				System.out.println(ci.getCiSpeed()+"	");
			}
			while(true) {
				int count=-1;
				System.out.println("상세정보를 볼려는 번호를 입력하세요(종료 : 0 )");
				int selectnum=sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if(selectnum == list.get(i).getCiNum()) {
						count=selectnum;
						System.out.println("상세정보 보기");
						HeroDetailInfo det=new HeroDAO().getHeroDetailInfo();
						System.out.println("영웅이름 : "+det.getCiName()+"	"+"영웅 설명 : "+det.getComment());
						break;
					}
					
				}
				if(selectnum==0) {
					System.out.println("종료~!");
					break;
				}else if(selectnum != count) {
					System.out.println("잘못된번호입니다");
				}
			}//내부 while . 상세정보보기 while문 
			
			break;
		}
		else if(inputNum==2) { //자동차 정보 입력
			
			break;
		}
		else if(inputNum==3) { //자동차 정보 수정 
			
			break;
		}
		else if(inputNum==4) { // 자동차 정보 삭제 
			
			break;
		}else {				//다른거 입력했을때 다시입력 
			System.out.println("다시입력해주세요");
		}
		}//end while
		System.out.println("종료");
		
		sc.close();
			

	}//end main

}//end class
