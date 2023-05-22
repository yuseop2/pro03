package kr.go.yeosu.model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.go.yeosu.dto.UserDTO;
import kr.go.yeosu.util.MySQL8;

import kr.go.yeosu.util.AES256;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String key = "%03x";
	String qpw;
	
	//로그인 SQL 실행
		public int loginCheck(String id, String pw) throws InvalidKeyException,
		NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
		InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException,
		IllegalBlockSizeException, InvalidAlgorithmParameterException{
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					qpw = AES256.decryptAES256(rs.getString("pw"), key);
					System.out.println(qpw);
					if(pw.equals(qpw)){
						cnt = 1;
					} else {
						cnt = 0;
					} 
				} else {
					cnt = 9;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return cnt;
		}
		
		public int loginPass(String id, String pw) throws InvalidKeyException,
		NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
		InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException,
		IllegalBlockSizeException, InvalidAlgorithmParameterException{
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					qpw = AES256.decryptAES256(rs.getString("pw"), key);
					System.out.println(qpw);
					if(pw.equals(qpw)){
						cnt = 1;
					} else {
						cnt = 0;
					} 
				} else {
					cnt = 9;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return cnt;
		}
		
		public int idCheck(String id){
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					cnt = 1;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return cnt;
		}
		
		public int insertUser(UserDTO user){
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.INSERT_USER);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getPhone());
				pstmt.setString(5, user.getAddr());
				pstmt.setString(6, user.getEmail());
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
		
		public UserDTO myInfo(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
			UserDTO user = new UserDTO();
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					user.setId(rs.getString("id"));
					qpw = AES256.decryptAES256(rs.getString("pw"), key);
					int k = qpw.length();	//암호 글자수 세기
					String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
					String hpw = "";
					for(int i=0;i<k-3;i++){	//나머지는 *로 넣기
						hpw+="*";
					}
					user.setPw(vpw+hpw);
					user.setPhone(rs.getString("Phone"));
					user.setEmail(rs.getString("email"));
					user.setRegdate(rs.getString("regdate"));
					user.setAddr(rs.getString("addr"));

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return user;
		}
		
		public int updateUser(UserDTO user){
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.UPDATE_USER);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getPhone());
				pstmt.setString(5, user.getAddr());
				pstmt.setString(6, user.getEmail());
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
		
		public int updateUser2(UserDTO user){
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.UPDATE_USER2);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPhone());
				pstmt.setString(3, user.getAddr());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getId());
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
		
		
		public int deleteUser(String id){
			int cnt = 0;
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.DELETE_USER);
				pstmt.setString(1, id);
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
		
		public ArrayList<UserDTO> userList() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
			ArrayList<UserDTO> uList = new ArrayList<UserDTO>();
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_SELECT_ALL);
				rs = pstmt.executeQuery();
				while(rs.next()){
					UserDTO user = new UserDTO();
					user.setId(rs.getString("id"));
					qpw = AES256.decryptAES256(rs.getString("pw"), key);
					int k = qpw.length();	//암호 글자수 세기
					String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
					String hpw = "";
					for(int i=0;i<k-3;i++){	//나머지는 *로 넣기
						hpw+="*";
					}
					user.setPw(vpw+hpw);
					user.setName(rs.getString("name"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setRegdate(rs.getString("regdate"));
					user.setAddr(rs.getString("addr"));
					uList.add(user);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return uList;
		}
		public UserDTO getTel(String id) {
			UserDTO user = new UserDTO();
			try {
				con = MySQL8.getConnection();
				pstmt = con.prepareStatement(MySQL8.USER_LOGIN);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setRegdate(rs.getString("regdate"));
					user.setAddr(rs.getString("addr"));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(rs, pstmt, con);
			}
			return user;
		}
}
