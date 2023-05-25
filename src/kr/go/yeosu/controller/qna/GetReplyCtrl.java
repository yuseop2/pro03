package kr.go.yeosu.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.QnaDTO;
import kr.go.yeosu.model.QnaDAO;

@WebServlet("/GetReply.do")
public class GetReplyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String qno = request.getParameter("qno");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO qn = new QnaDTO();
		
		qn = dao.getQna2(qno);	//해당 질문 불러오기
		
		request.setAttribute("qn", qn);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/getReply.jsp");
		view.forward(request, response);
	}
}
