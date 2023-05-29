package kr.go.yeosu.controller.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.go.yeosu.dto.ReviewDTO;
import kr.go.yeosu.model.ReviewDAO;

@WebServlet("/AddReviewPro.do")
public class AddReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/review/img";	//업로드할 디렉토리
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//업로드할 파일 크기 제한
		String encType = "UTF-8";		//멀티파트 데이터의 인코딩 설정
		ServletContext context = getServletContext();	//현재 서블릿(프로젝트)의 위치 저장
		String uploadFilePath = context.getRealPath(savePath);  //서버 상에 실제 업로드되는 디렉토리 지정
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		int r_num = 0;
		String cate = "";
		String pcode = "";
		String id = "";
		String review = "";
		String fileName = "";
		String regdate = "";
						
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("pic"); // 업로드하고, 업로드된 파일의 이름 얻기
						
			if (fileName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 실패~!");				
				
			}  // 파일이 업로드 되었을때	
			r_num = Integer.parseInt(multi.getParameter("r_num"));
			cate = multi.getParameter("cate");			
			pcode = multi.getParameter("pcode");
			id = multi.getParameter("id");
			review = multi.getParameter("review");	
			regdate = multi.getParameter("regdate");
			
			System.out.println(multi.getParameter("r_num"));
			System.out.println(multi.getParameter("cate"));
			System.out.println(multi.getParameter("pcode"));
			System.out.println(multi.getParameter("${sid }"));
			System.out.println(multi.getParameter("id"));
			
			System.out.println(multi.getParameter("fileName"));
			System.out.println(multi.getParameter("regdate"));
			
			
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
			
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO rev = new ReviewDTO();
		rev.setR_num(r_num);
		
		rev.setCate(cate);
		rev.setPcode(pcode);
		rev.setId(id);
		rev.setReview(review);
		
		rev.setPic(fileName);
		rev.setRegdate(regdate);
		
		
		
		int cnt = dao.addReview(rev);
		if(cnt==0){ //리뷰 등록 실패
			String msg = "리뷰가 등록되지 못했습니다.";
			request.setAttribute("msg", msg);			
			response.sendRedirect("AddReview.do?="+rev.getPcode());
		} else { //리뷰 등록 성공
			response.sendRedirect("GetReview.do?pcode="+pcode);
		}		
	}
}
