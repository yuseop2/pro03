package kr.go.yeosu.test;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.go.yeosu.util.MySQL8;
=======
import java.sql.*;
>>>>>>> df8f963aecadd4b41755529d0572dc57eecbefce

import org.junit.Test;

public class MySQLTest {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
<<<<<<< HEAD
	String sql = "";
	
	@Test
	public void test1() {
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("item1"));
				System.out.println(rs.getInt("item2"));
				System.out.println(rs.getString("item3"));
				System.out.println("*****************************************");
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
	}
=======
	
		
	@Test
	public void test1() {
		System.out.println("테스트 1");		
		//fail("Not yet implemented");
		
	}

	
>>>>>>> df8f963aecadd4b41755529d0572dc57eecbefce
}
