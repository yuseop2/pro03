package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.model.ReviewDAO;

@WebServlet("/DeleteReview.do")
public class DeleteReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.delReview(r_num);
		
		if(cnt==0){			 //리뷰 삭제 실패
			String msg = "리뷰를 삭제하지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("ReviewList.do");
		} else {				 //리뷰 삭제 성공시 목록으로 가기
			response.sendRedirect("ReviewList.do");
		}
	}

}
