package kr.go.yeosu.controller.place;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.model.PlaceDAO;
import kr.go.yeosu.vo.CategoryVO;

@WebServlet("/InsertPlace.do")
public class InsertPlaceCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "상품을 등록합니다.";
		
		PlaceDAO dao = new PlaceDAO();
		ArrayList<CategoryVO> cateList = dao.getFirstCategoryList(); 
		
		for(CategoryVO cate : cateList){
			System.out.println(cate.getCt());
			System.out.println(cate.getGname());
		}
		
		request.setAttribute("cateList", cateList);
		request.setAttribute("msg", msg);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/place/InsertPlace.jsp");
		view.forward(request, response);
	}
}
