package kr.go.yeosu.controller.review;

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

import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.dto.UserDTO;
import kr.go.yeosu.model.ReviewDAO;
import kr.go.yeosu.model.UserDAO;

@WebServlet("/GetReview.do")
public class GetReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int r_num = Integer.parseInt(request.getParameter("r_num"));	
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		rev = rdao.getReview(r_num);
		String pic = ""; 
		String filepath1 = "";
		
		if(rev.getPic()!=null){
			pic = rev.getPic().substring(5); 
			filepath1 = rev.getPic().substring(0,4);
			pic = URLEncoder.encode(pic, "UTF-8");	
		}
		
		request.setAttribute("pic", pic);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("rev", rev);
		
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
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/getReview.jsp");
		view.forward(request, response);
	}
}