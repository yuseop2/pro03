package kr.go.yeosu.util;

import java.sql.*;

public class MySQL8 {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "test5";
	String pass = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql ="";
	
	try {
		Class.forName(driver);
		try {
			conn = DriverManager.getConnection(url, user, pass);
			sql = " select ";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
	
				while(rs.next()){
					//01022221111
					String t1 = rs.getString("phone").substring(0, 3); //010
					String t2 = rs.getString("phone").substring(3, 7); //2222
					String t3 = rs.getString("phone").substring(7); //1111
					String tel = t1 + "-" + t2 + "-" + t3;
					
					//20220101
					String y = rs.getString("regdate").substring(0, 4);	//2022
					String m = rs.getString("regdate").substring(4, 6); //01
					String d = rs.getString("regdate").substring(6); //01
					String date1 = y + "-" + m + "-" + d;  //2022-01-01
				}				
				rs.close();
				pstmt.close();
				conn.close();
				
			} catch (Exception e){
				System.out.println("SQL 전송실패");
			}
		} catch (Exception e){
			System.out.println("데이터베이스 연결 실패");
		}
	} catch (Exception e){
		System.out.println("드라이버 로딩 실패");
	}
}

