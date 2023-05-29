package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.model.ReviewDAO;

@WebServlet("/UpdateReviewPro.do")
public class UpdateReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		
		int r_num = Integer.parseInt(request.getParameter("r_num"));		
		
		rev.setR_num(r_num);
		
		String id = request.getParameter("id"); 
		rev.setId(id);
		
		String pcode = request.getParameter("pcode");
		rev.setPcode(pcode);
		rev.setReview(request.getParameter("review"));
				
		int cnt = dao.updateReview(rev);
		if(cnt>0){
			response.sendRedirect("PlaceDetail.do?pcode="+pcode);
		} else {
			response.sendRedirect("UpdateReview.do?r_num="+r_num);
		}
	}
}
