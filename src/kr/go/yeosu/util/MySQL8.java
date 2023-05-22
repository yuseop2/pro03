package kr.go.yeosu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL8 {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/yeosu?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pass = "1234";
	
	//샘플 관련 SQL
	public final static String SAMPLE_SELECT_ALL = "select * from sample1 order by item3 desc";
	public final static String SAMPLE_SELECT_ONE = "select * from sample1 where item1=?";
	public final static String SAMPLE_INSERT = "insert into sample1 values(?,?,default)";
	public final static String SAMPLE_UPDATE = "update sample1 set item2=? where item1=?";
	public final static String SAMPLE_DELETE = "delete from sample1 where item1=?";
	
	//회원 관련 SQL
	public final static String USER_SELECT_ALL = "select * from tbl_user order by regdate desc";
	public final static String USER_LOGIN =  "select * from tbl_user where id=?";
	public final static String INSERT_USER = "insert into tbl_user(id, pw, name, phone, addr, email) values (?,?,?,?,?,?)";
	public final static String UPDATE_USER = "update tbl_user set pw=?, name=?, phone=?, addr=?, email=? where id=?";
	public final static String UPDATE_USER2 = "update tbl_user set name=?, phone=?, addr=?, email=? where id=?";
	public final static String DELETE_USER = "delete from tbl_user where id=?";
	
	//Notice 관련 SQL
	public final static String NOTICE_SELECT_ALL = "select * from tbl_notice order by idx desc";
	public final static String NOTICE_SELECT_ONE = "select * from tbl_notice where idx=?";
	public final static String NOTICE_READCOUNT_UPDATE = "update tbl_notice set readcnt=readcnt+1 where idx=?";
	public final static String INSERT_NOTICE = "insert into tbl_notice values (default, ?, ?, ?, ?, default, default)";
	public final static String UPDATE_NOTICE = "update tbl_notice set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	public final static String UPDATE_NOTICE2 = "update tbl_notice set title=?, content=?, resdate=sysdate where idx=?";
	public final static String DELETE_NOTICE = "delete from tbl_notice where idx=?";
	
	//Place 관련 SQL
	
	public final static String PLACE_CATENAME_SELECT = "select * from tbl_cate where cate=?";
	public final static String PLACE_SELECT_BYCATE = "select * from tbl_place where cate=? order by pname";
	public final static String PLACE_SELECT = "select * from tbl_place where pcode=?";
	
	public final static String PLACE_CATE_SELECT = "select * from tbl_place where cate=?";
	public final static String PLACE_CATE_SELECT2 = "select * from tbl_place where cate like ?||'%'";
	public final static String PLACE_CATE_SELECT3 = "select * from tbl_place where cate like concat(?, '%')";
	
	public final static String FIRST_CATEGORY_SELECT = "select distinct substr(cate,1,2) as ct, gname from tbl_cate group by substr(cate,1,2), gname order by ct";
	public final static String SECOND_CATEGORY_SELECT = "select cate, cname from tbl_cate where cate like ?||'%' order by cate";
	
	public final static String PCODE_GENERATOR = "select pcode from (select * from tbl_place where cate=? order by pcode desc) where rownum = 1";
	public final static String INSERT_PLACE = "insert into tbl_place values (?, ?, ?, ?, ?, ?, ?)";
	public final static String UPDATE_PLACE = "update tbl_place set pname=?, cate=?, addr=?, phone=?, comm=?, pic=? where pcode=?";
	public final static String DELETE_PLACE = "delete from tbl_place where pcode=?";
			
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}