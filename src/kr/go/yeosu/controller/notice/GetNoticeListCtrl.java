package kr.go.yeosu.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.NoticeDTO;
import kr.go.yeosu.model.NoticeDAOMySQL;

@WebServlet("/NoticeList.do")
public class GetNoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAOMySQL ndao = new NoticeDAOMySQL();
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		notiList = ndao.noticeListAll();
		request.setAttribute("notiList", notiList);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/notiList.jsp");
		view.forward(request, response);
	}
}
