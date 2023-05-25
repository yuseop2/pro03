package kr.go.yeosu.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.QnaDTO;
import kr.go.yeosu.model.QnaDAO;

@WebServlet("/AddReplyPro.do")
public class AddReplyProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		QnaDTO qna = new QnaDTO();
		QnaDAO dao = new QnaDAO();
		
		String parno = request.getParameter("parno");
		qna.setQno(dao.getQnoGenerator());
		qna.setParno(parno);
		qna.setTitle(request.getParameter("title"));
		qna.setContent(request.getParameter("content"));
		qna.setAuthor(request.getParameter("author"));
		
		int cnt = dao.addReply(qna);
		
		if(cnt==0){ //답변하기 실패
			String msg = "답변이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("AddReply.do?parno="+parno);
		} else { //답변하기 성공
			response.sendRedirect("QnaList.do");
		}
	}
}
