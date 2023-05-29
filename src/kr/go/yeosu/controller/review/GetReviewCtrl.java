package kr.go.yeosu.controller.review;

import java.io.IOException;
import java.util.HashMap;

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

@WebServlet("/GetReview.do")
public class GetReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String pcode = request.getParameter("pcode");	
		ReviewDAO rdao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		PlaceDAO pdao = new PlaceDAO();
		PlaceDTO place = pdao.getPlace(pcode);
		
		String cate = rev.getCate();	 
		HashMap<String, String> cateMap = pdao.getCategory(cate);
				
		request.setAttribute("place", place);	//한 개의 상품 정보
		request.setAttribute("cateMap", cateMap);	//카테고리 정보
		request.setAttribute("rev", rev);
				
		int r_num = 0;
		rev = rdao.reviewDetail(r_num);	
						
		System.out.println(request.getParameter("${rev.r_num }"));
					
		//디스패치로 view를 생성하여 getNotice.jsp로 요청 받은 noti를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/review/getReview.jsp");
		view.forward(request, response);
	}
}