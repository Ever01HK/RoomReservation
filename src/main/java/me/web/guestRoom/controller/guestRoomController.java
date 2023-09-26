package me.web.guestRoom.controller;

import java.io.IOException;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.web.guestRoom.service.RoomCntVO;


@Controller
public class guestRoomController {

    @RequestMapping("/calendar")
	public String calendar( @RequestParam(value="pCurrYear", required=false) String sShowYear,
						    @RequestParam(value="pCurrMonth", required=false) String sShowMonth,
	                        @RequestParam(value="pOperand", required=false) String sOperand, final ModelMap model) throws Exception {
    	
    	int year, month;
    	LocalDate date = LocalDate.now();
    	
    	if(sShowYear == null)
    	{
    		year = date.getYear(); // return year
    		month = date.getMonthValue(); // return month
    		
    	}else {
    		if(sShowMonth.equals("11") && sOperand.equals("1")) {
    			year = Integer.parseInt(sShowYear)+1;
    			month = 0;
    		}else if(sShowMonth.equals("0") && sOperand.equals("-1")) {
    			year = Integer.parseInt(sShowYear)-1;
    			month = 11;
    		}else {
    			year = Integer.parseInt(sShowYear);
    			month = Integer.parseInt(sShowMonth)+Integer.parseInt(sOperand);
    		}
    	}    	
    		
    	//int day = date.getDayOfMonth(); // return month(int)
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
    	Date dateMonth = format.parse(year+"-"+month);
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(dateMonth); 
    	int start = calendar.get(Calendar.WEEK_OF_MONTH);
    	
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.DATE, -1);
        int end = calendar.get(Calendar.WEEK_OF_MONTH);
        int weekOfMonth = (end - start + 1);
        model.addAttribute("nWeekCnt",weekOfMonth );
    	
        calendar.set(Calendar.DAY_OF_MONTH, 1);
    	//Week day of the first day of month
    	int nFirstWeekDay = calendar.get(Calendar.DAY_OF_WEEK);
    	int nLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	    	
    	int day = date.getDayOfMonth(); 
    	
    	List<RoomCntVO> listRoomCnt = new ArrayList();
    	for( int i=0; i<nLastDay; i++ )
    	{
    		RoomCntVO RCntVO = new RoomCntVO();
    		
    		RCntVO.setnDay(i);
    		RCntVO.setnBigCnt((int)((Math.random()*10000)%6)+1);
    		RCntVO.setnMidCnt((int)((Math.random()*10000)%4)+1);
    		RCntVO.setnSmallCnt((int)((Math.random()*10000)%3)+1);
    		
    		listRoomCnt.add(RCntVO);
    	}
    	
    	model.addAttribute("sYear",year );
    	model.addAttribute("sMonth",month );
    	model.addAttribute("sYearMonth", year+"-"+(month<10? "0"+month: month));
    	model.addAttribute("nFirstWeekDay", nFirstWeekDay);
    	model.addAttribute("nLastDay", nLastDay);
    	model.addAttribute("listRoomCnt", listRoomCnt);
		return "/test";
	} 
    
  
   

    
}
