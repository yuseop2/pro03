package kr.go.yeosu.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.model.ReviewDAO;

@WebServlet("/AdminReviewList.do")
public class AdminReviewListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewDTO> rList = rdao.reviewListAll();
				
		request.setAttribute("rList", rList);
		
		RequestDispatcher view = request.getRequestDispatcher("/review/reviewList.jsp");
		view.forward(request, response);
	}
}
