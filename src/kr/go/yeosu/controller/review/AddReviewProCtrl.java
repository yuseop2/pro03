package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddReviewPro.do")
public class AddReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReviewDAO dao = new ReviewDAO();
		Review rev = new Review();
		rev.setW_num(dao.getW_numGenerator());
		
		String id = request.getParameter("id"); 
		rev.setId(id);
		
		String o_code = request.getParameter("o_code");
		rev.setO_code(o_code);
		rev.setReview(request.getParameter("review"));
		rev.setRating(Integer.parseInt(request.getParameter("rating")));
		
		int cnt = dao.addReview(rev);
		if(cnt>0){
			response.sendRedirect("MySalesList.do?id="+id);
		} else {
			response.sendRedirect("AddResultUserReview.do?o_code="+o_code);
		}
	}
}
