package kr.go.yeosu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.yeosu.dto.QnaDTO;
import kr.go.yeosu.util.MySQL8;

public class QnaDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//질문 및 답변글번호 생성
	public String getQnoGenerator(){
		String qno = "";
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.QNO_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qno = rs.getString("qno");
			} else {
				qno = "00000000";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		
		int tmp = Integer.parseInt(qno) + 1;
		if(qno=="00000000"){
			qno = "0000000" + tmp;
		} else if(tmp>=10000000){
			qno = tmp + "";
		} else if(tmp>=1000000){
			qno = "0" + tmp;
		} else if(tmp>=100000) {
			qno = "00" + tmp;
		} else if(tmp>=10000) {
			qno = "000" + tmp;
		} else if(tmp>=1000) {
			qno = "0000" + tmp;
		} else if(tmp>=100) {
			qno = "00000" + tmp;
		} else if(tmp>=10) {
			qno = "000000" + tmp;
		} else {
			qno = "0000000" + tmp;
		}
		return qno;
	}
	
	//질문 등록하기
	public int addQna(QnaDTO qna){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.ADD_QNA);
			pstmt.setString(1, qna.getQno());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getContent());
			pstmt.setString(4, qna.getAuthor());
			pstmt.setString(5, qna.getQno());				
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
	
	//답변 등록하기
	public int addReply(QnaDTO qna){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.ADD_REPLY);
			pstmt.setString(1, qna.getQno());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getContent());
			pstmt.setString(4, qna.getAuthor());
			pstmt.setString(5, qna.getParno());				
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
	
	//질문 삭제하기
	public int delQna(String qno){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_QNA);
			pstmt.setString(1, qno);				
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
	
	//답변 삭제하기
	public int delReply(String qno){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_REPLY);
			pstmt.setString(1, qno);				
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
	
	//질문 수정하기
	public int updateQna(QnaDTO qna){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_QNA);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getQno());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;
	} 

	//답변 수정하기
	public int updateReply(QnaDTO qna){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_QNA);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getQno());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	//전체 질문 및 답변 목록
	public ArrayList<QnaDTO> getQnaList(){
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.QNA_LIST);
			rs = pstmt.executeQuery();
			System.out.println("qnaList 실행중");
			while(rs.next()){
				System.out.println("qna목록 받아오는중");
				QnaDTO qna = new QnaDTO();
				qna.setQno(rs.getString("qno"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setAuthor(rs.getString("author"));
				qna.setResdate(rs.getString("resdate"));
				qna.setLev(rs.getInt("lev"));
				qna.setParno(rs.getString("parno"));				
				qna.setVisited(rs.getInt("visited"));
				qnaList.add(qna);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return qnaList;
	}
	
	//해당 질문과 그 답변 그룹
	public ArrayList<QnaDTO> getQna(String qno){
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.QNA_SELECT);
			pstmt.setString(1, qno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnaDTO qna = new QnaDTO();
				qna.setQno(rs.getString("qno"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setAuthor(rs.getString("author"));
				qna.setResdate(rs.getString("resdate"));
				qna.setLev(rs.getInt("lev"));
				qna.setParno(rs.getString("parno"));				
				qna.setVisited(rs.getInt("visited"));
				qnaList.add(qna);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return qnaList;
	} 
	
	//질문 상세보기
	public QnaDTO getQna2(String qno){
		QnaDTO qna = new QnaDTO();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.QNA_SELECT_ONE);
			pstmt.setString(1, qno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qna.setQno(rs.getString("qno"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setAuthor(rs.getString("author"));
				qna.setResdate(rs.getString("resdate"));
				qna.setLev(rs.getInt("lev"));
				qna.setParno(rs.getString("parno"));				
				qna.setVisited(rs.getInt("visited"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return qna;
	} 
	
	//해당 질문에 대한 답변 목록(질문 제외)
	public ArrayList<QnaDTO> getReplyList(String qno){
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.REPLY_LIST);
			pstmt.setString(1, qno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnaDTO qna = new QnaDTO();
				qna.setQno(rs.getString("qno"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setAuthor(rs.getString("author"));
				qna.setResdate(rs.getString("resdate"));
				qna.setLev(rs.getInt("lev"));
				qna.setParno(rs.getString("parno"));				
				qna.setVisited(rs.getInt("visited"));
				qnaList.add(qna);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return qnaList;
	} 
}
