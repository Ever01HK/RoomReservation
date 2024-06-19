package me.web.guestRoom.service;

/*****************************************************************************************************
Program : RoomCntVO.java
Description : A VO class for calendar page
Creator : Hyunkyung Oh
Company : Vision IT co. Ltd.
Date : APR 22

**History**
Date             the basis of work             Programmer
APR 22				Created						Hyunkyung Oh            
*****************************************************************************************************/

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
