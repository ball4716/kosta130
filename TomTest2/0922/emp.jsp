<%@page import="t0921.dto.Emp"%>
<%@page import="java.util.List"%>
<%@page import="t0921.dao.EmpDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- emp.jsp --%>
<body>
  <%!
      Connection conn;
  %>
  <%
     try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
    		                         ,"scott","tiger");
    	 out.print("DB연결성공!!");      
     }catch(Exception e){
         out.print("실패다!!"+ e);
     }  
  %>
  <hr>  
  <center>
  <h3>사원정보 목록</h3>
   <table border="1" cellpadding="5">
      <tr bgcolor="yellow">
         <th>사원번호</th>
         <th>사원명</th>
         <th>입사일</th>
         <th>급여</th>
         <th>부서명</th>
      </tr>
      <% //사원번호, 사원명, 입사일, 급여, 부서명
          String path = application.getRealPath("");
          EmpDAO dao = new EmpDAO(path);//new EmpDAO("g:/jaelee/workspace/TomTest2/");
          List<Emp> list =  dao.selectAll();          
          for(int i=0; i<list.size(); i++){
        	 Emp emp = list.get(i);
      %>
         <tr>
            <td><%= emp.getEmpno() %></td>
            <td><%= emp.getEname() %></td>
            <td><%= emp.getHiredate() %></td>
            <td><%= emp.getSal() %></td>
            <td><%= emp.getDname() %></td>
         </tr>
      <%} %>
   </table>
   
   
  </center>
</body>
</html>






