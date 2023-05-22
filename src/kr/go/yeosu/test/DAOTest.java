package kr.go.yeosu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.go.yeosu.util.MySQL8;

import org.junit.Test;

public class DAOTest {
	
	SampleDAO dao = new SampleDAO();	//이렇게 하니 됨 근데 완벽하지않음
	
	@Test
	public void getListTest(){
		System.out.println("목록 데이터 테스트");
		ArrayList<Sample1> samList = new ArrayList<Sample1>();		
		samList = dao.getSampleList();
		for(Sample1 sam:samList){
			System.out.println("아이디 : "+sam.getItem1());
			System.out.println("포인트 : "+sam.getItem2());
			System.out.println("가입일 : "+sam.getItem3());
			System.out.println("----------------------------");
		}		
	}
	
	@Test
	public void getSampleTest(){
		System.out.println("목록에서 레코드 검색 테스트");
		Sample1 sam = new Sample1();		
		sam = dao.getSample("kimkitae");
		if(sam!=null){
			System.out.println("아이디 : "+sam.getItem1());
			System.out.println("포인트 : "+sam.getItem2());
			System.out.println("가입일 : "+sam.getItem3());
		}
	}
	
	@Test
	public void addSampleTest(){
		System.out.println("레코드 추가 테스트");
		Sample1 sam = new Sample1();
		sam.setItem1("leeyuseop");
		sam.setItem2(100);
		int cnt = dao.addSample(sam);
		if(cnt>0){
			System.out.println("레코드추가성공");
		}		
	}
	
	@Test
	public void updateSampleTest(){
		System.out.println("레코드 수정 테스트");
		Sample1 sam = new Sample1();
		sam.setItem1("leeyuseop");
		sam.setItem2(1000);
		int cnt = dao.updateSample(sam);
		if(cnt>0){
			System.out.println("레코드 수정 성공");
		}		
	}
	
	@Test
	public void deleteSampleTest(){
		System.out.println("레코드 삭제 테스트");		
		int cnt = dao.deleteSample("leeyuseop") ;
		if(cnt>0){
			System.out.println("레코드 삭제 성공");
		}
	}	
}
