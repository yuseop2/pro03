package kr.go.yeosu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.util.MySQL8;

public class ReviewDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;	
	
	//리뷰 리스트 전체 - 어드민용
	public ArrayList<ReviewDTO> reviewListAll(){
		ArrayList<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ReviewDTO rev = new ReviewDTO();
				rev.setR_num(rs.getInt("r_num"));
				rev.setCate(rs.getString("cate"));
				rev.setPcode(rs.getString("pcode"));
				rev.setId(rs.getString("id"));
				rev.setReview(rs.getString("review"));
				rev.setPic(rs.getString("pic"));
				rev.setRegdate(rs.getString("regdate"));
				reviewList.add(rev);				
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return reviewList;
	}	
	
	//리뷰리스트 장소마다(pcode)
	public ArrayList<ReviewDTO> reviewListByPcode(String pcode){
		ArrayList<ReviewDTO> rList = new ArrayList<ReviewDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_SELECT_BYPCODE);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ReviewDTO rev = new ReviewDTO();
				rev.setR_num(rs.getInt("r_num"));
				rev.setCate(rs.getString("cate"));
				rev.setPcode(rs.getString("pcode"));
				rev.setId(rs.getString("id"));
				rev.setReview(rs.getString("review"));
				rev.setPic(rs.getString("pic"));
				rev.setRegdate(rs.getString("regdate"));
				rList.add(rev);				
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return rList;
	}
	
	//리뷰 디테일 (하나 r_num)	
	public ReviewDTO reviewDetail(int r_num){
		ReviewDTO rev = new ReviewDTO();
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_SELECT_ONE);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rev.setR_num(rs.getInt("r_num"));
				rev.setCate(rs.getString("cate"));
				rev.setPcode(rs.getString("pcode"));
				rev.setId(rs.getString("id"));
				rev.setReview(rs.getString("review"));
				rev.setPic(rs.getString("pic"));
				rev.setRegdate(rs.getString("regdate"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return rev;
	}	
	
	//리뷰 등록하기
	public int addReview(ReviewDTO rev){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_INSERT);
			pstmt.setString(1, rev.getCate());
			pstmt.setString(2, rev.getPcode());
			pstmt.setString(3, rev.getId());
			pstmt.setString(4, rev.getReview());
			pstmt.setString(5, rev.getPic());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
			MySQL8.close(pstmt, con);
			return cnt;
		}	
	
	//리뷰 수정하기
	public int updateReview(ReviewDTO rev){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_UPDATE);
			pstmt.setString(1, rev.getReview());
			pstmt.setString(2, rev.getId());
			pstmt.setInt(3, rev.getR_num());
			
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
	
	//리뷰 삭제하기
	public int delReview(int r_num){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REVIEW_DELETE);
			pstmt.setInt(1, r_num);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(pstmt, con);
		}
		return cnt;
	}
}
