package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddResultUserReview.do")
public class AddResultUserReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o_code = request.getParameter("o_code");
		
		ReviewDAO dao = new ReviewDAO();
		Product pro = dao.getProduct(o_code);
		
		SalesDAO sdao = new SalesDAO();
		SalesVO sale = sdao.getSales(o_code);
		
		String msg = "이용후기를 작성합니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("pro", pro);
		request.setAttribute("sale", sale);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/addReview.jsp");
		view.forward(request, response);
	}
}
