package kr.go.yeosu.controller.place;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.model.PlaceDAO;
import kr.go.yeosu.vo.CategoryVO;

import org.json.JSONObject;

@WebServlet("/CategoryLoading.do")
public class CategoryLoadingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate1 = request.getParameter("cate1");
		
		System.out.println("request cate : "+cate1);
		
		String msg = "새로운 분류 카테고리를 로딩합니다.";
		
		PlaceDAO dao = new PlaceDAO();
		ArrayList<CategoryVO> ctList = dao.getSecondCategoryList(cate1); 

		for(CategoryVO cate : ctList){
			System.out.println("cate : "+cate.getCate());
			System.out.println("gname : "+cate.getGname());
			System.out.println("cname : "+cate.getCname());
		}
		
		request.setAttribute("ctList", ctList);
		request.setAttribute("msg", msg);
		

		
		response.setContentType("text/html; charset=UTF-8");
		JSONObject json = new JSONObject();
		json.put("ctList", ctList);
		json.put("msg", msg);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}
