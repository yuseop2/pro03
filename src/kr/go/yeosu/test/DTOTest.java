package kr.go.yeosu.test;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.go.yeosu.util.MySQL8;
=======
import static org.junit.Assert.*;
>>>>>>> df8f963aecadd4b41755529d0572dc57eecbefce

import org.junit.Test;

public class DTOTest {
<<<<<<< HEAD
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	String sql = "";
	ArrayList<Sample1> samList = new ArrayList<Sample1>();
	
	public ArrayList<Sample1> db(){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Sample1 sam = new Sample1();
				sam.setItem1(rs.getString("item1"));
				sam.setItem2(rs.getInt("item2"));
				sam.setItem3(rs.getString("item3"));
				samList.add(sam);
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return samList;
	}
	
	@Test
	public void test() {
		ArrayList<Sample1> testList = db();
		for(Sample1 sam:testList){
			System.out.println("아이디 : "+sam.getItem1());
			System.out.println("포인트 : "+sam.getItem2());
			System.out.println("가입일 : "+sam.getItem3());
			System.out.println();
		}
		//fail("Not yet implemented");
	}
}
class Sample1 {
	private String item1;
	private int item2;
	private String item3;
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public int getItem2() {
		return item2;
	}
	public void setItem2(int item2) {
		this.item2 = item2;
	}
	public String getItem3() {
		return item3;
	}
	public void setItem3(String item3) {
		this.item3 = item3;
	}
=======

	@Test
	public void test() {
		fail("Not yet implemented");
	}

>>>>>>> df8f963aecadd4b41755529d0572dc57eecbefce
}
