package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateReviewPro.do")
public class UpdateReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReviewDAO dao = new ReviewDAO();
		Review rev = new Review();
		
		String w_num = request.getParameter("w_num");		
		rev.setW_num(w_num);
		
		String id = request.getParameter("id"); 
		rev.setId(id);
		
		String o_code = request.getParameter("o_code");
		rev.setO_code(o_code);
		rev.setReview(request.getParameter("review"));
		if(request.getParameter("new_rating")==null) {
			rev.setRating(Integer.parseInt(request.getParameter("rating")));
		} else {
			rev.setRating(Integer.parseInt(request.getParameter("new_rating")));	
		}
		
		int cnt = dao.updateReview(rev);
		if(cnt>0){
			response.sendRedirect("MySalesList.do?id="+id);
		} else {
			response.sendRedirect("UpdateReview.do?w_num="+w_num);
		}
	}
}
