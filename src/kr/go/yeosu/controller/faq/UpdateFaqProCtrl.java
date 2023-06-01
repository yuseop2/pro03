package kr.go.yeosu.controller.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.FaqDTO;
import kr.go.yeosu.model.FaqDAO;

@WebServlet("/UpdateFaqPro.do")
public class UpdateFaqProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String fno = request.getParameter("fno");
		String fquestion = request.getParameter("fquestion");
		String fanswer = request.getParameter("fanswer");

		FaqDTO faq = new FaqDTO();
		faq.setFno(fno);
		faq.setFquestion(fquestion);
		faq.setFanswer(fanswer);
		
		FaqDAO dao = new FaqDAO();
		int cnt = dao.updateFaq(faq);
	
		if(cnt==0){
			response.sendRedirect("UpdateFaq.do?fno="+fno);
		} else {
			response.sendRedirect("FaqList.do");
		}
	}
}
