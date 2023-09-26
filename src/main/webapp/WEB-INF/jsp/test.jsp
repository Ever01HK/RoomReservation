<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Guest Room Main Page</title>
</head>
<style>
    #calendarTable, #calendarTable th, #calendarTable td{
        border-collapse: collapse;
    }

    #calendarTable{
        boarder: 2px solid #000;
        width: 800px;
    }
   
    #calendarTable th, #calendarTable td{
        width: 100px;
        border: 1px solid #000;
        border-collapse: collapse;
        padding: 3px;
    }

    #calendarTable th{
        background-color: #666;
        color: #fff;
    }

    #calendarTable td{
        height: 105px;
        text-align: right;
        padding:4px;
    }

    #calendarTable td.empty{
        background-color: #DFDCD8;
    }

    #calendarTable td.toDayColor{
        background-color: #6C7EAA;
    }

        
</style>
<script>
function goCalendar(nOperand){
	$("#hdnOperand").val(nOperand);
	alert("<c:url value='/calendar'/>");
    document.sForm.action = "<c:url value='/calendar'/>";
    document.sForm.submit();		
}
</script>
<body>
<body>
<div id="contentLine">
        <div style="width:70%;margin:0 auto;padding-top:20px;">
            <table style="margin:0 auto; border-collapse:collapse; border:0;">
                <tr>
                    <td width="150" style="text-align:left;valign:middle;">
                        <a onClick="goCalendar(-1);" style="cursor:pointer;">
                            <font size="2">◀ Previous Month</font>
                        </a>
                    </td>
                    <td width="150" style="text-align:center;valign:middle;">
                        <h2>${sYearMonth}</h2>
                    </td>
                    <td width="150" style="text-align:right;valign:middle;">
                        <a onClick="goCalendar(1);" style="cursor:pointer;">
                            <font size="2">Next Month ▶</font>
                        </a>
                    </td>
                </tr>
            </table>
            <table id="calendarTable" style="margin:0 auto;">
                <tr>
                    <th style="color:red;">SUN</th>
                    <th>MON</th>
                    <th>TUE</th>
                    <th>WED</th>
                    <th>THU</th>
                    <th>FRI</th>
                    <th style="color:blue;">SAT</th>
                </tr>
                <c:set var="day" value="${1}" />
                <c:set var="dayVal" value="" />
                <c:forEach var="i" begin="1" end="${nWeekCnt}" step="1">
                    <tr>                   
	                     <c:forEach var="j" begin="1" end="7" step="1">
	                            <c:if test="${j eq nFirstWeekDay && day eq 1}">
	                                <c:set var="dayVal" value="${day}" />
	                            </c:if>
	                            <c:if test="${dayVal ne '' && day ne 1}">
	                                <c:set var="dayVal" value="${day}" />
	                            </c:if>
	                            <td>
	                                <c:if test="${j eq 1}">
	                                    <div style="color:Red;">   <!-- Sunday -->
	                                </c:if>
	                                <c:if test="${j eq 7}">
	                                    <div style="color:Blue;">   <!-- Saturday -->
	                                </c:if>
	                                <c:if test="${j ne 1 || j ne 7}">
	                                    <div style="text-aligh:left;padding=left:3px;margin-top:-5px;">   <!-- Week day -->
	                                </c:if>
	                                ${dayVal}
	                                </div>
	
	                                <c:if test="${dayVal ne ''}">   <!-- 날짜가 있으면 숙소 갯수 확인해서 표시 처리 -->
	                                    <c:set var="charDay" value="${day}" />
	                                    <c:if test="${day < 10}">
	                                        <c:set var="charDay" value="0${day}" />
	                                    </c:if>
	                                    <c:set var="now" value="<%=new java.util.Date() %>" />
	                                    <fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true" var="intNow" />
	                                    <fmt:parseDate var="calendarDay" value="${sYearMonth}-${charDay}" pattern="yyyy-MM-dd" /> 
	                                    <fmt:parseNumber value="${calendarDay.time / (1000*60*60*24)}" integerOnly="true" var="intCDay" />
	                                    <div style="height:75px; padding-right:5px;">
	                                        <c:if test="${intCDay - intNow >= -1}">  <!--Do not display room count if applydate is before now -->
	                                                <c:if test="${j ne 1 && j ne 4 && j ne 5}"> <!--  Fri, Sat, Mon, Tue only available -->
	                                                <c:if test="${listRoomCnt[datVal - 1].nBigCnt > 0}">
	                                                    <div>   
	                                                        <a onClick="goApply(${dayVal}, '1', '${sYearMonth}${charDay}', ${listRoomCnt[dayVal - 1].nBigCnt}}, ${j}, ${listRoomCnt1111111111})" style="cursor:pointer;">
	                                                            ${listRoomCnt[dayVal - 1].nBigCnt}:Big(<c:out value="${listRoomCnt[dayVal-1].nBigCnt}" />) </a>
	                                                        <input type="hidden" id="hnBigCnt" value="<c:out value='${listRoomCnt[dayVal-1].nBigCnt}' />" />
	                                                        <input type="hidden" id="hnBigCnt${dayVal}" value="<c:out value='${listRoomCnt[dayVal-1].nBigCnt}' />" />
	                                                    </div>
	                                                </c:if>
	                                            </c:if>
	                                            <c:if test="${listRoomCnt[dayVal - 1].nMidCnt > 0}">
	                                                    <div>   
	                                                        <a onClick="goApply(${dayVal}, '2', '${sYearMonth}${charDay}', ${listRoomCnt[dayVal - 1].nMidCnt})" style="cursor:pointer;">
	                                                            Middium(<c:out value="${listRoomCnt[dayVal-1].nMidCnt}" />) </a>
	                                                        <input type="hidden" id="hnMidCnt" value="<c:out value='${listRoomCnt[dayVal-1].nMidCnt}' />" />
	                                                        <input type="hidden" id="hnMidCnt${datVal}" value="<c:out value='${listRoomCnt[dayVal-1].nMidCnt}' />" />
	                                                    </div>
	                                            </c:if>
	                                            <c:if test="${listRoomCnt[dayVal - 1].nSmallCnt > 0}">
	                                                    <div>   
	                                                        <a onClick="goApply(${dayVal}, '2', '${sYearMonth}${charDay}', ${listRoomCnt[dayVal - 1].nSmallCnt})" style="cursor:pointer;">
	                                                            Small(<c:out value="${listRoomCnt[dayVal-1].nSmallCnt}" />) </a>
	                                                        <input type="hidden" id="hnSmallCnt" value="<c:out value='${listRoomCnt[dayVal-1].nSmallCnt}' />" />
	                                                        <input type="hidden" id="hnSmallCnt${datVal}" value="<c:out value='${listRoomCnt[dayVal-1].nSmallCnt}' />" />
	                                                    </div>
	                                            </c:if>
	                                        </c:if>
	                                    </div>
	                                </c:if>
	                            </td>
	                            <c:if test="${dayVal ne ''}">
	                                <c:set var="day" value="${day +1}" />
	                            </c:if>
	                            </td>
	                            <c:if test="${day > nLastDay}">
	                                <c:set var="dayVal" value="" />
	                            </c:if>
	                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
     </div>
     <form id="sForm" name="sForm" method="post" action="<c:url value="/calendar" />" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" id="hdnCurrYear" name="pCurrYear" value="<c:out value="${sYear}"/>">
				<input type="hidden" id="hdnCurrMonth" name="pCurrMonth" value="<c:out value="${sMonth}"/>">
				<input type="hidden" id="hdnOperand" name="pOperand" value="0">
	 </form>
</body>
</html>