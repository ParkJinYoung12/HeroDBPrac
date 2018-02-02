package heroDBPrac;
import java.util.ArrayList;
import java.util.Scanner;
public class HeroMain {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Scanner scStr=new Scanner(System.in);
		HeroDAO dao = new HeroDAO();
		while(true) {
		System.out.println("===========================");
		System.out.println("번호를 입력하세요.");
		System.out.println("1.영웅 정보 보기.");
		System.out.println("2.영웅 정보 입력.");
		System.out.println("3.영웅 정보 수정.");
		System.out.println("4.영웅 정보 삭제.");
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
						count=list.get(i).getCiNum();
						System.out.println("상세정보 보기");
						HeroDetailInfo det=new HeroDAO().getHeroDetailInfo();
						System.out.println("영웅이름 : "+det.getCiName()+"	"+"영웅 설명 : "+det.getComment());
						break;
					}
					
				}
				if(selectnum==0) {
					System.out.println("종료~!");
					break;
				}else if(selectnum != count) {  //for list.size
					System.out.println("잘못된번호입니다");
				}
			}//내부 while . 상세정보보기 while문 
			
			break;
		}
		else if(inputNum==2) { //자동차 정보 입력
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
			System.out.println("(새로운 정보 입력1)(다른숫자 종료)");
			int select=sc.nextInt();
			if(select == 1) {
				System.out.println("영웅 이름을 입력하세요");String cname=scStr.nextLine();
				System.out.println("영웅의 힘(공격력) 입력하세요[숫자] :");int cpower=sc.nextInt();
				System.out.println("영웅의 스피드를 입력하세요[숫자] :");int cspeed=sc.nextInt();
				System.out.println("영웅의 설명을 쓰시오");String comment=scStr.nextLine();
				HeroDetailInfo hdi=new HeroDetailInfo(cname,cpower,cspeed,comment);
				
				dao.insertHeroDetail(hdi);
				
			}
			
			break;
		}
		else if(inputNum==3) { //자동차 정보 수정 
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
	
	private static boolean isValidNum(int selectNum,ArrayList<HeroInfo> list) {
		/*boolean isValid =false; 쓸필요없다~~~~~*/ 
//		list = new ArrayList<CarDetail>();
		for (int i = 0; i <list.size(); i++) {
			if(selectNum==list.get(i).getCiNum()) {
				
				return true;
			}
		}
		return false;
	}
	
}//end class
