package me.web.guestRoom.service;

import java.io.Serializable;

/**********************************************************
프로그램명 : TfVO.java
설명 : 공통 상세코드 VO 클래스
작성자 : 조정은
소속 : (주)에이치씨
일자 : 19.10.31
프로그램설명
관리자 상세코드관리 상세코드 데이터 처리 모델 클래스

**프로그램이력**
수정일          작업근거             유지보수담당
'19.10.31       최초생성             조정은
**********************************************************/

public class RoomCntVO {
	
	private int nDay;
	private int nBigCnt;
	private int nMidCnt;
	private int nSmallCnt;
	public int getnDay() {
		return nDay;
	}
	public void setnDay(int nDay) {
		this.nDay = nDay;
	}
	public int getnBigCnt() {
		return nBigCnt;
	}
	public void setnBigCnt(int nBigCnt) {
		this.nBigCnt = nBigCnt;
	}
	public int getnMidCnt() {
		return nMidCnt;
	}
	public void setnMidCnt(int nMidCnt) {
		this.nMidCnt = nMidCnt;
	}
	public int getnSmallCnt() {
		return nSmallCnt;
	}
	public void setnSmallCnt(int nSmallCnt) {
		this.nSmallCnt = nSmallCnt;
	}
	
	
	
	
	
    
}
