package kr.go.yeosu.controller.place;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.model.PlaceDAO;

import org.json.JSONObject;

@WebServlet("/ProductCodeGenerator.do")
public class ProductCodeGeneratorCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		String msg = "새로운 장소코드를 발생하였습니다.";
		
		PlaceDAO dao = new PlaceDAO();
		String pcode = dao.getPcodeGenerator(cate);
		
		request.setAttribute("pcode", cate+pcode);
		request.setAttribute("msg", msg);
		
		response.setContentType("text/html; charset=UTF-8");
		JSONObject json = new JSONObject();
		json.put("pcode", cate+pcode);
		json.put("msg", msg);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}