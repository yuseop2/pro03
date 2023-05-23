package kr.go.yeosu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//해당 상품의 이용후기 불러오기
	public Review getProduct(String o_code){
		Product pro = new Product();
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.REVIEW_PRODUCT);
			pstmt.setString(1, o_code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pro.setP_code(rs.getString("p_code"));
				pro.setP_name(rs.getString("p_name"));
				pro.setWeight(rs.getString("weight"));
				pro.setPrice(rs.getInt("price"));
				pro.setP_comm(rs.getString("p_comm"));
				pro.setAmount(rs.getInt("amount"));
				pro.setPic1(rs.getString("pic1"));
				pro.setPic2(rs.getString("pic2"));
				pro.setPic3(rs.getString("pic3"));			
				pro.setCate(rs.getString("cate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, con);
		}
		return pro;
	}
	
	//결제 번호 생성
	public String getW_numGenerator(){
		String w_num = "";
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.W_NUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				w_num = rs.getString("w_num");
			} else {
				w_num = "10000";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, con);
		}		
		int tmp = Integer.parseInt(w_num) + 1;
		w_num = tmp + "";
		return w_num;
	}
	
	//리뷰 등록하기
	public int addReview(Review rev){
		int cnt = 0;
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.ADD_REVIEW);
			pstmt.setString(1, rev.getW_num());
			pstmt.setString(2, rev.getId());
			pstmt.setString(3, rev.getO_code());
			pstmt.setString(4, rev.getReview());
			pstmt.setInt(5, rev.getRating());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, con);
		}
		SalesDAO dao = new SalesDAO();
		cnt = cnt + dao.okSales(rev.getO_code());
		return cnt;
	}
	
	
	//해당 상품의 리뷰 불러오기
	public ArrayList<Review> getP_codeByReview(String p_code){
		ArrayList<Review> rList = new ArrayList<Review>();
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.P_CODEBY_REVIEW);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review rev = new Review();
				rev.setW_num(rs.getString("w_num"));
				rev.setId(rs.getString("id"));
				rev.setO_code(rs.getString("o_code"));
				rev.setW_date(rs.getString("w_date"));
				rev.setReview(rs.getString("review"));
				rev.setRating(rs.getInt("rating"));
				rList.add(rev);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, con);
		}
		return rList;
	}
	
	//리뷰 한 건 불러오기
	public Review getW_numByReview(String w_num){
		Review rev = new Review();
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.W_NUM_BY_REVIEW);
			pstmt.setString(1, w_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rev.setW_num(rs.getString("w_num"));
				rev.setId(rs.getString("id"));
				rev.setO_code(rs.getString("o_code"));
				rev.setW_date(rs.getString("w_date"));
				rev.setReview(rs.getString("review"));
				rev.setRating(rs.getInt("rating"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, con);
		}
		return rev;
	}
	
	//리뷰 수정하기
	public int updateReview(Review rev){
		int cnt = 0;
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.UPDATE_REVIEW);
			pstmt.setString(1, rev.getReview());
			pstmt.setInt(2, rev.getRating());
			pstmt.setString(3, rev.getId());
			pstmt.setString(4, rev.getW_num());
			
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, con);
		}
		return cnt;
	}
	
	//리뷰 수정하기
	public int deleteReview(String w_num){
		int cnt = 0;
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.DELETE_REVIEW);
			pstmt.setString(1, w_num);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, con);
		}
		return cnt;
	}
	
	public ArrayList<Review> getAllReview(){
		ArrayList<Review> rList = new ArrayList<Review>();
		try {
			con = Oracle11.getConnection();
			pstmt = con.prepareStatement(Oracle11.ALL_REVIEW);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review rev = new Review();
				rev.setW_num(rs.getString("w_num"));
				rev.setId(rs.getString("id"));
				rev.setO_code(rs.getString("o_code"));
				rev.setW_date(rs.getString("w_date"));
				rev.setReview(rs.getString("review"));
				rev.setRating(rs.getInt("rating"));
				rList.add(rev);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, con);
		}
		return rList;
	}
}
