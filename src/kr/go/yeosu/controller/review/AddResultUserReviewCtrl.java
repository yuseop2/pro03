package kr.go.yeosu.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.PlaceDTO;
import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.model.PlaceDAO;
import kr.go.yeosu.model.ReviewDAO;

@WebServlet("/AddResultUserReview.do")
public class AddResultUserReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewDTO> rev = rdao.reviewListByPcode(pcode);
		
		PlaceDAO pdao = new PlaceDAO();		
		PlaceDTO place = pdao.getPlace(pcode);
						
		String msg = "이용후기를 작성합니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("place", place);
		request.setAttribute("rev", rev);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/addReview.jsp");
		view.forward(request, response);
	}
}
