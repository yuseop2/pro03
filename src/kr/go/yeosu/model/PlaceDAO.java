package kr.go.yeosu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import kr.go.yeosu.dto.Cate;
import kr.go.yeosu.dto.Place;
import kr.go.yeosu.util.MySQL8;

public class PlaceDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<Place> placeListByCate(String cate){
		ArrayList<Place> placeList = new ArrayList<Place>();
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PLACE_SELECT_BYCATE);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Place place = new Place();
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
	
	public Place getPlace(String pcode){
		
		Place place = new Place();
		
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
	//카테고리 로딩
		public HashMap<String, String> getCategory(String cate) {
			HashMap<String, String> cateMap = new HashMap<String, String>();
			String cateGroup = "";
			String cateName = "";
			
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.PLACE_CATENAME_SELECT);
				pstmt.setString(1, cate);
				rs = pstmt.executeQuery();
				if(rs.next()){
					cateGroup = "catename";
					cateName = rs.getString("catename");
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
			cateMap.put(cateGroup, cateName);
			return cateMap;
		}
		
	//대분류 코드 반환
			public ArrayList<Cate> getFirstCategoryList(){
				ArrayList<Cate> cateList = new ArrayList<Cate>();
				try {
					con = MySQL8.getConnection();
					pstmt = con.prepareStatement(MySQL8.FIRST_CATEGORY_SELECT);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Cate cate = new Cate();
						cate.setCate(rs.getString("cate"));
						cate.setGname(rs.getString("gname"));
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
			
			//중분류 코드 반환
			public ArrayList<Cate> getSecondCategoryList(String ct){
				ArrayList<Cate> cateList = new ArrayList<Cate>();
				try {
					con = MySQL8.getConnection();
					pstmt = con.prepareStatement(MySQL8.SECOND_CATEGORY_SELECT);
					pstmt.setString(1, ct);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Cate cate = new Cate();
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
		
	//상품 코드 발생기
			public String getProductCodeGenerator(String cate){
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
	public int insertPlace(Place place){
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
	public Place updatePlace(String pcode){
		Place place = new Place();
		
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_PLACE);
			pstmt.setString(1, place.getPname());
			pstmt.setString(2, place.getCate());
			pstmt.setString(3, place.getAddr());
			pstmt.setString(4, place.getPhone());
			pstmt.setString(5, place.getComm());	
			pstmt.setString(6, "data/"+place.getPic());
			pstmt.setString(7, place.getPcode());
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
