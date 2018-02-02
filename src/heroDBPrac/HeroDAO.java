package heroDBPrac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class HeroDAO {
	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ORACLE_USER_ID = "system";
	private static final String ORACLE_USER_PW = "1234";
	//접속 및 커리 처리에 필요한 객체들
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;

	public ArrayList<HeroInfo> getHeroInfoList() throws Exception{
		ArrayList<HeroInfo> list = new ArrayList<HeroInfo>();
		
		try {
			//dbms 접속정보 읽어오기
			conn=DriverManager.getConnection(ORACLE_URL,ORACLE_USER_ID,ORACLE_USER_PW);
			//1.sql문을 String으로 준비
			String sql = "select * from heroInfo"; //리터럴에 ; 이게(세미콜론) 들어가면 안된다 
			//2.쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			//3.실행 결과를 ResultSet 객체에 담는다.
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				HeroInfo cInfo=new HeroInfo();
				cInfo.setCiNum(rs.getInt(1));
				cInfo.setCiName(rs.getString(2));
				cInfo.setCiFower(rs.getInt(3));
				cInfo.setCiSpeed(rs.getInt(4));
				list.add(cInfo);
				
			}
			
		} catch (Exception e) {
			
		}finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		return list;
	}

	
	public HeroDetailInfo getHeroDetailInfo() throws Exception {
		HeroDetailInfo hdi=new HeroDetailInfo();
		try {
			//dbms 접속정보 읽어오기
			conn=DriverManager.getConnection(ORACLE_URL,ORACLE_USER_ID,ORACLE_USER_PW);
			//1.sql문을 String으로 준비
			String sql = "select * from heroInfo"; //리터럴에 ; 이게(세미콜론) 들어가면 안된다 
			//2.쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			//3.실행 결과를 ResultSet 객체에 담는다.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				hdi=new HeroDetailInfo();
				
				hdi.setCiName(rs.getString(2));
				hdi.setComment(rs.getString(5));
							
			}
			
		} catch (Exception e) {
			
		}finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		
		
		return hdi;
		
	}


	public void insertHeroDetail(HeroDetailInfo hdi)throws Exception {
		try {
			//dbms 접속정보 읽어오기
			conn=DriverManager.getConnection(ORACLE_URL,ORACLE_USER_ID,ORACLE_USER_PW);
			//1.sql문을 String으로 준비
			String sql = "insert into heroInfo (ciNum,ciName,cipower,cispeed,CICOMMENT) values (seq_carInfo_ciNum.nextval,?,?,?,?)"; //리터럴에 ; 이게(세미콜론) 들어가면 안된다 
			//2.쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hdi.getCiName());
			pstmt.setInt(2, hdi.getCiFower());
			pstmt.setInt(3, hdi.getCiSpeed());
			pstmt.setString(4,hdi.getComment());
			
		 // 첫번째 물음표 쿼리에 대한 세팅값
			//3.실행 결과를 ResultSet 객체에 담는다.
		pstmt.executeUpdate();/*여기 바꿀꺼임~~~~~~~~~~*/
			//결과로 나온 데이터가  1건있으면if 구문 블록 실행 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
			pstmt.close();
			
		}
		
	}//메소드 끝
	
	
	
	
	
} //end class 
