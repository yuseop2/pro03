package kr.go.yeosu.controller.place;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.model.PlaceDAO;

@WebServlet("/DeletePlace.do")
public class DeletePlaceCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		
		PlaceDAO dao = new PlaceDAO();
		int cnt = dao.deletePlace(pcode);
		if(cnt==0){ //상품 삭제 실패
			String msg = "상품 정보를 삭제하지 못했습니다.";
			request.setAttribute("msg", msg);
			
			//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
			RequestDispatcher view = request.getRequestDispatcher("UpdatePlace.do?pcode="+pcode);
			view.forward(request, response);
		} else { //상품 수정 성공시 목록으로 가기
			response.sendRedirect("ProductList.do");
		}
	}
}
