package kr.go.yeosu.service;

import java.util.ArrayList;

import kr.go.yeosu.dto.NoticeDTO;
import kr.go.yeosu.model.NoticeDAO;
import kr.go.yeosu.model.NoticeDAOMySQL;
import kr.go.yeosu.model.NoticeDAOMaria;

public class NoticeService {
	
		NoticeDAO dao = new NoticeDAOMySQL();
		NoticeDAO dao2 = new NoticeDAOMaria();
		
		public ArrayList<NoticeDTO> noticeListAll(){		//공지 목록
			ArrayList<NoticeDTO> notiList = dao.noticeListAll();
			return notiList;			
		}			
		public NoticeDTO getNotice(int no)	{				//공지 상세 보기
			NoticeDTO noti = new NoticeDTO();
			return noti;
		}
		public int addNotice(NoticeDTO dto){					//공지 추가
			int cnt = dao.addNotice(dto);
			return cnt;
		}
		public int delNotice(int no){									//공지 삭제
			int cnt = dao.delNotice(no);
			return cnt;
		}
		public NoticeDTO updateNotice(NoticeDTO dto){			//공지 수정
			NoticeDTO noti = new NoticeDTO();
			return noti;
		}
}
