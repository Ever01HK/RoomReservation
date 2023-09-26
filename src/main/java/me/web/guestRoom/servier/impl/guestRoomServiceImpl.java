package me.web.guestRoom.servier.impl;

import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.web.guestRoom.service.guestRoomService;
import me.web.guestRoom.service.RoomCntVO;

/**********************************************************
프로그램명 : KhnpTfServiceImpl.java
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
@Service("mainService")
public class guestRoomServiceImpl implements guestRoomService{

//    @Resource(name="mainDAO")
//    private mainDAO maindao;
//    
//    /** EgovPropertyService */
//   	@Resource(name = "propertiesService")
//   	protected EgovPropertyService propertiesService;
//   	
//   	@Resource(name = "EgovFileMngUtil")
//   	private EgovFileMngUtil fileUtil;
   	
  
   	 //엑셀 리스트
   	 
   @Override
   	public void excel_list(final RoomCntVO mainVO) throws Exception {
   		//List<mainVO>
   		//return maindao.excel_list(mainVO);
   	}
//       
//  

   	
}
