package me.web.guestRoom.servier.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.web.guestRoom.service.RoomCntVO;
/**********************************************************
프로그램명 : KhnpTfDAO.java
설명 : 임시시설물 임시설치물 조회,관리 클래스
작성자 : 조정은
소속 : (주)에이치씨
일자 : 19.10.31
프로그램설명
임시시설물 임시설치물 조회, 관리에 대한 데이터베이스 접근 클래스를 정의한다.

**프로그램이력**
수정일                        작업근거             유지보수담당
19.10.31          최초생성                조정은
**********************************************************/
@Repository("mainDAO")
public class mainDAO {
	
	/**
	 * 엑셀 리스트
	 */
	public void  excel_list(final RoomCntVO mainVO) throws Exception {
		//List<mainVO>
		//return (List<mainVO>) list("TfDAO.excel_write_list", mainVO);
	}
	
}
