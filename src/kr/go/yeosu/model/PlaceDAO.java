package kr.go.yeosu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import kr.go.yeosu.dto.PlaceDTO;
import kr.go.yeosu.util.MySQL8;
import kr.go.yeosu.vo.CategoryVO;

public class PlaceDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//전체 장소 목록 보기 - 관리자용
	public ArrayList<PlaceDTO> getPlaceList(){
		ArrayList<PlaceDTO> placeList = new ArrayList<PlaceDTO>();
		// 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 placeList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PlaceDTO place = new PlaceDTO();
				place.setPcode(rs.getString("pcode"));
				place.setPname(rs.getString("pname"));
				place.setCate(rs.getString("cate"));
				place.setAddr(rs.getString("addr"));
				place.setPhone(rs.getString("phone"));
				place.setComm(rs.getString("comm"));
				place.setPic(rs.getString("pic"));					
				placeList.add(place);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return placeList;
	}
	//장소 상세 보기
	public PlaceDTO getPlace(String pcode){		
		PlaceDTO place = new PlaceDTO();		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_SELECT );
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				place.setPcode(rs.getString("pcode"));
				place.setPname(rs.getString("pname"));
				place.setCate(rs.getString("cate"));
				place.setAddr(rs.getString("addr"));
				place.setPhone(rs.getString("phone"));
				place.setComm(rs.getString("comm"));
				place.setPic(rs.getString("pic"));			
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return place;
	}	
	
	//카테고리별 장소 목록 로딩 - 일반 회원용
	public ArrayList<PlaceDTO> catePlaceList(String cate) {
		ArrayList<PlaceDTO> placeList = new ArrayList<PlaceDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_CATE_SELECT);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PlaceDTO place = new PlaceDTO();
				place.setPcode(rs.getString("pcode"));
				place.setPname(rs.getString("pname"));
				place.setCate(rs.getString("cate"));
				place.setAddr(rs.getString("addr"));
				place.setPhone(rs.getString("phone"));
				place.setComm(rs.getString("comm"));
				place.setPic(rs.getString("pic"));					
				placeList.add(place);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return placeList;
	}	
	//카테고리별 장소 목록 로딩 - 관리자용
	public ArrayList<PlaceDTO> AdminCatePlaceList(String cate) {
		ArrayList<PlaceDTO> placeList = new ArrayList<PlaceDTO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_CATE_SELECT2);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PlaceDTO place = new PlaceDTO();
				place.setPcode(rs.getString("pcode"));
				place.setPname(rs.getString("pname"));
				place.setCate(rs.getString("cate"));
				place.setAddr(rs.getString("addr"));
				place.setPhone(rs.getString("phone"));
				place.setComm(rs.getString("comm"));
				place.setPic(rs.getString("pic"));					
				placeList.add(place);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return placeList;
	}
	
	//카테고리 로딩
	public HashMap<String, String> getCategory(String cate) {
		HashMap<String, String> cateMap = new HashMap<String, String>();
		String gname= "";
		String cname = "";
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_CNAME_SELECT);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			if(rs.next()){
				gname = rs.getString("gname");
				cname = rs.getString("cname");
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}		
		cateMap.put(gname, cname);
		return cateMap;
	}
	
	//대분류 코드 반환
	public ArrayList<CategoryVO> getFirstCategoryList(){
		ArrayList<CategoryVO> cateList = new ArrayList<CategoryVO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FIRST_CATEGORY_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryVO cate = new CategoryVO();
				cate.setCate(rs.getString("ct"));
				cate.setGname(rs.getString("gname"));				
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cateList;
	}
	
	//중분류 코드 반환
	public ArrayList<CategoryVO> getSecondCategoryList(String ct){
		ArrayList<CategoryVO> cateList = new ArrayList<CategoryVO>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SECOND_CATEGORY_SELECT);
			pstmt.setString(1, ct);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryVO cate = new CategoryVO();
				cate.setCate(rs.getString("cate"));
				cate.setCname(rs.getString("cname"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return cateList;
	}

	//장소 코드 발생기
	public String getPcodeGenerator(String cate){
		String pcode = "";
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PCODE_GENERATOR);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pcode = rs.getString("pcode").substring(4);
			} else {
				pcode = "0";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		int tmp = 0;
		if(pcode==null){
			pcode = tmp + "0001";
		} else {
			tmp = Integer.parseInt(pcode) + 1;
			if(tmp>=1000){
				pcode = tmp + "";
			} else if(tmp>=100) {
				pcode = "0" + tmp;
			} else if(tmp>=10) {
				pcode = "00" + tmp;
			} else {
				pcode = "000" + tmp;
			}			
		}
		return pcode;
	}
				
	//장소 입력			
	public int insertPlace(PlaceDTO place){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_PLACE);
			pstmt.setString(1, place.getPcode());
			pstmt.setString(2, place.getPname());
			pstmt.setString(3, place.getCate());
			pstmt.setString(4, place.getAddr());
			pstmt.setString(5, place.getPhone());
			pstmt.setString(6, place.getComm());			
			pstmt.setString(7, "data/"+place.getPic());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}
	
	//장소 업데이트
	public int updatePlace(PlaceDTO place){
		int cnt=0;		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_PLACE);
			pstmt.setString(1, place.getPname());
			pstmt.setString(2, place.getCate());
			pstmt.setString(3, place.getAddr());
			pstmt.setString(4, place.getPhone());
			pstmt.setString(5, place.getComm());	
			pstmt.setString(6, place.getPic());
			pstmt.setString(7, place.getPcode());
			cnt = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return cnt;
	}	
	
	//장소 삭제
	public int deleteNotice(String pcode) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_NOTICE);
			pstmt.setString(1, pcode);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}
}
