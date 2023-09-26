package me.web.guestRoom.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.web.guestRoom.service.RoomCntVO;

/**********************************************************
프로그램명 : KhnpTfService.java
설명 : 임시시설물 임시설치물 조회, 관리를 위한 서비스 구현 클래스
작성자 : 조정은
소속 : (주)에이치씨
일자 : 19.10.31
프로그램설명
임시시설물 임시설치물 조회, 관리를 위한 서비스 구현 클래스를 정의한다. 

**프로그램이력**
수정일                        작업근거             유지보수담당
19.10.31          최초생성                조정은
**********************************************************/
public interface guestRoomService {
	
    /**
	 * 엑셀 리스트
	 * @param TfVO TfVO
	 * @return List(설비분류 목록)
	 * @throws Exception
	 */
	public void excel_list(final RoomCntVO mainVO) throws Exception;
	
	
   	
   	
	

}
