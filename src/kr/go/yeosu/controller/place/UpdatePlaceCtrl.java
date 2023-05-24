package kr.go.yeosu.controller.place;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.PlaceDTO;
import kr.go.yeosu.model.PlaceDAO;

@WebServlet("/UpdatePlace.do")
public class UpdatePlaceCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//상품코드를 받아서 dao로 전달하여 한 개의 특정 상품에 대한 정보를 로딩
		String pcode = request.getParameter("pcode");
		PlaceDAO dao = new PlaceDAO();
		PlaceDTO place = dao.getPlace(pcode); 
		
		//카테고리 코드를 저장하여 dao에서 처리한 후 해당 카테고리명을 로딩
		String cate = place.getCate();	 
		HashMap<String, String> cateMap = new HashMap<String, String>();  
		cateMap = dao.getCategory(cate);
		System.out.println("카테고리명 : "+cateMap.get("cname"));
		request.setAttribute("place", place);	//한 개의 상품 정보
		request.setAttribute("cateMap", cateMap);	//카테고리 정보	
		request.setAttribute("cname", cateMap.get("cname"));	//카테고리 정보
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/place/updatePlace.jsp");
		view.forward(request, response);
	}
}
