<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- result3.jsp --%>
<body>
  <h3>결과페이지</h3>
  <hr>
  <%
  //MultipartRequest(HttpServletRequest request, String saveDirectory, 
  // int maxPostSize, String encoding, FileRenamePolicy policy)
     int maxSize=5*1024*1024;//1kb--> 1mb  5Mb 사이즈 제한
     String saveDirectory=application.getRealPath("upload");
     MultipartRequest mr = 
    		 new MultipartRequest(request,saveDirectory,maxSize,"euc-kr",
    				new DefaultFileRenamePolicy());
     //-------> 생성자를 통해 파일 업로드 실행!!
     out.println("파일업로드성공!!");
  %>
  <hr>
   전송된 이름: <%= mr.getParameter("name") %> <br>
   원래 파일명: <%= mr.getOriginalFileName("myfile") %> <br>
   저장된 파일명: <%= mr.getFilesystemName("myfile") %>
  
</body>
</html>






