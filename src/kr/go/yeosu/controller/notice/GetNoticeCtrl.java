package kr.go.yeosu.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.yeosu.dto.NoticeDTO;
import kr.go.yeosu.dto.UserDTO;
import kr.go.yeosu.model.NoticeDAO;
import kr.go.yeosu.model.UserDAO;

@WebServlet("/GetNotice.do")
public class GetNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int idx = 0 ;
		NoticeDAO ndao = new NoticeDAO();
		NoticeDTO noti = new NoticeDTO();
		noti = ndao.getNotice(idx);
		String file1 = ""; 
		String filepath1 = "";
		
		if(noti.getFile1()!=null){
			file1 = noti.getFile1().substring(5); 
			filepath1 = noti.getFile1().substring(0,4);
			file1 = URLEncoder.encode(file1, "UTF-8");	
		}
		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("noti", noti);
		
		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		UserDAO udao = new UserDAO();
		UserDTO user = new UserDTO(); 
		try {
			user = udao.myInfo(id);
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| javax.crypto.IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);		
	
		//디스패치로 view를 생성하여 getNotice.jsp로 요청 받은 noti를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/getNotice.jsp");
		view.forward(request, response);
	}
}
