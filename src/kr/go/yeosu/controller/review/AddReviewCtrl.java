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

@WebServlet("/AddReview.do")
public class AddReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
						
		PlaceDAO pdao = new PlaceDAO();		
		PlaceDTO place = pdao.getPlace(pcode);
		ReviewDAO rdao = new ReviewDAO();	
		int r_num=0;
		ReviewDTO rev = rdao.reviewDetail(r_num);
		
		String cate = place.getCate();	 
		HashMap<String, String> cateMap = new HashMap<String, String>();  
		cateMap = pdao.getCategory(cate);
		
		String msg = "이용후기를 등록합니다.";
		request.setAttribute("msg", msg);
		
		request.setAttribute("place", place);	//한 개의 상품 정보
		request.setAttribute("cateMap", cateMap);	//카테고리 정보	
		request.setAttribute("cname", cateMap.get("cname"));	//카테고리 정보
		request.setAttribute("rev", rev);
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/review/addReview.jsp");
		view.forward(request, response);
	}
}
