<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Insert title here</title>
</head>
<%-- result.jsp --%>
<body>
	<h3>결과페이지</h3>
	<hr>
	<%
		request.setCharacterEncoding("euc-kr");
	%>
	이름: ${param.name }<%=request.getParameter("name") %><br>
	파일: ${param.myfile }
	<hr>
	<%
		ServletInputStream sis = request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(sis));
		String str;
		
		BufferedWriter bw = null;
		String filename=null;
		System.out.println(getServletContext().getRealPath(""));
		String delimeter = br.readLine();
		while((str=br.readLine()) != null){
			//out.write(str+"<br>");
			if(filename==null && str.indexOf("filename=\"")!=-1)
				filename = str.substring(str.indexOf("filename=\"")+10, str.length()-1);
			if(filename != null){
				bw = new BufferedWriter(new FileWriter(getServletContext().getRealPath("")+"\\upload\\"+filename));
				System.out.println("filename="+filename);
				filename = null;
			}
			if(bw != null){
				while(true){
					str = br.readLine();
					if(str.contains(delimeter)) break;
					bw.write(str+"\n");
				}
			} 
		}
		bw.close();
	%>
</body>
</html>