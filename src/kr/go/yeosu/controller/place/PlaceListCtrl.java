package kr.go.yeosu.controller.place;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.PlaceDTO;
import kr.go.yeosu.model.PlaceDAO;

@WebServlet("/PlaceList.do")
public class PlaceListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		PlaceDAO dao = new PlaceDAO();
		ArrayList<PlaceDTO> placeList = new ArrayList<PlaceDTO>();
		HashMap<String, String> cateMap	= new HashMap<String, String>();		
		if(cate==null){
			placeList = dao.getPlaceList();
			cate = "0101";
			cateMap.put("cname","전체");
		} else {
			placeList = dao.catePlaceList(cate);
			cateMap = dao.getCategory(cate);
		}		
	
		request.setAttribute("placeList", placeList);
		request.setAttribute("cateMap", cateMap);
		
		//디스패치로 view를 생성하여 getNotice.jsp로 요청 받은 noti를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/place/placeList.jsp");
		view.forward(request, response);
	}
}
