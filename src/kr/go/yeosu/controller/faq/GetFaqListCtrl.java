package kr.go.yeosu.controller.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.FaqDTO;
import kr.go.yeosu.model.FaqDAO;

@WebServlet("/FaqList.do")
public class GetFaqListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		FaqDAO dao = new FaqDAO();
		ArrayList<FaqDTO> faqList = new ArrayList<FaqDTO>();
		faqList = dao.getFaqList();
		request.setAttribute("faqList", faqList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/faq/faqList.jsp");
		view.forward(request, response);
	}
}