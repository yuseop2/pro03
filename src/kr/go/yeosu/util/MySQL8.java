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
	public final static String UPDATE_NOTICE = "update tbl_notice set title=?, content=?, file1=?, regdate=default where idx=?";
	public final static String UPDATE_NOTICE2 = "update tbl_notice set title=?, content=?, regdate=default where idx=?";
	public final static String DELETE_NOTICE = "delete from tbl_notice where idx=?";
	
	//Place 관련 SQL	
	public final static String PLACE_SELECT_ALL = "select * from tbl_place order by cate desc"; //관리자용 전체 장소보기
	public final static String PLACE_SELECT = "select * from tbl_place where pcode=?";		//장소 상세보기
		
	public final static String PLACE_CATE_SELECT = "select * from tbl_place where cate=?";	//카테고리별 장소목록(일반회원)
	public final static String PLACE_CATE_SELECT2 = "select * from tbl_place where cate like ?"; //카테고리별 장소목록(관리자)
	public final static String PLACE_CATE_SELECT3 = "select * from tbl_place where cate like concat(?, '%')";
	
	public final static String PLACE_CNAME_SELECT = "select * from tbl_cate where cate=?";	//카테고리 로딩
	public final static String FIRST_CATEGORY_SELECT = "select distinct substr(cate,1,2) as ct, gname from tbl_cate group by substr(cate,1,2), gname order by ct";	//대분류코드반환
	public final static String SECOND_CATEGORY_SELECT = "select cate, cname, gname from tbl_cate where cate like ? order by cate";	//중분류코드반환
	public final static String PCODE_GENERATOR = "select * from tbl_place where cate=? order by pcode desc limit 1";	//pcode 발생기

	public final static String INSERT_PLACE = "insert into tbl_place values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public final static String UPDATE_PLACE = "update tbl_place set pname=?, cate=?, addr=?, phone=?, comm=?, pic=? lat=?, lng=? where pcode=?";
	public final static String DELETE_PLACE = "delete from tbl_place where pcode=?";
	
	//Review 관련 SQL
	public final static String REVIEW_SELECT_ALL = "select * from tbl_review order by regdate desc";
	public final static String REVIEW_SELECT_BYCATE = "select * from tbl_review where cate=?";
	public final static String REVIEW_SELECT_ONE = "select * from tbl_review where pcode=?";
	public final static String REVIEW_INSERT = "insert into tbl_review(cate, pcode, id, review, pic) values (?,?,?,?,?)";
	public final static String REVIEW_UPDATE = "update tbl_review SET review=? where id=? and r_num=?";
	public final static String REVIEW_DELETE = "delete from tbl_review where r_num=?";
		
	//QnA 관련 SQL
	public final static String QNO_GENERATOR = "select * from qna order by qno desc limit 1 ;";
	public final static String ADD_QNA = "insert into qna values (?,?,?,?,now(),1,?,0)";
	public final static String ADD_REPLY = "insert into qna values (?,?,?,?,now(),2,?,0)";
	public final static String QNA_LIST = "select * from qna order by parno desc, qno asc";
	public final static String QNA_SELECT = "select * from qna where parno=? order by qno asc";
	public final static String QNA_SELECT_ONE = "select * from qna where qno=?";
	public final static String REPLY_LIST = "select * from qna where parno=? and lev=2 order by qno asc";
	public final static String REPLY_SELECT = "select * from qna where parno=? and lev=2 order by qno asc";
	public final static String REPLY_SELECT_ONE = "select * from qna where lev=2 and qno=? order by qno asc";
	public final static String UPDATE_QNA = "update qna set title=?, content=? where qno=?";
	public final static String DELETE_QNA = "delete from qna where parno=?";
	public final static String DELETE_REPLY = "delete from qna where qno=?";	
	
	
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