package kr.go.yeosu.model;

import java.util.ArrayList;
import kr.go.yeosu.dto.NoticeDTO;

public interface NoticeDAO {
	public ArrayList<NoticeDTO> noticeListAll();		//공지 목록
	public NoticeDTO getNotice(int no);					//공지 상세 보기
	public int addNotice(NoticeDTO dto);					//공지 추가
	public int delNotice(int no);									//공지 삭제
	public int updateNotice(NoticeDTO dto);				//공지 수정
}