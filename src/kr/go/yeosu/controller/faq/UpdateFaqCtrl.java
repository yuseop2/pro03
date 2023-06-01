package kr.go.yeosu.controller.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.FaqDTO;
import kr.go.yeosu.model.FaqDAO;

@WebServlet("/UpdateFaq.do")
public class UpdateFaqCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String fno = request.getParameter("fno");
		
		FaqDAO dao = new FaqDAO();
		FaqDTO faq = new FaqDTO();
		faq = dao.getFaq(fno);
		request.setAttribute("faq", faq);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/faq/updateFaq.jsp");
		view.forward(request, response);
	}
}
