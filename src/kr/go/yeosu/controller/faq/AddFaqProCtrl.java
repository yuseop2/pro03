package kr.go.yeosu.controller.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.FaqDTO;
import kr.go.yeosu.model.FaqDAO;


@WebServlet("/AddFaqPro.do")
public class AddFaqProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		FaqDAO dao = new FaqDAO();
		
		String fno = dao.getFnoGenerator();
		String fquestion = request.getParameter("fquestion");
		String fanswer = request.getParameter("fanswer");

		FaqDTO faq = new FaqDTO();
		faq.setFno(fno);
		faq.setFquestion(fquestion);
		faq.setFanswer(fanswer);
		
		int cnt = dao.addFaq(faq);
	
		if(cnt==0){
			response.sendRedirect("AddFaq.do");
		} else {
			response.sendRedirect("FaqList.do");
		}
	}
}