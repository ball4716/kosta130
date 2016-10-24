<%@tag import="t0926.Product"%>
<%@tag pageEncoding="UTF-8" body-content="scriptless" %>

<%@attribute name="border" %>
<%@attribute name="bgcolor" %>

<!-- JSP페이지 작성과 흡사 -->
<h3><jsp:doBody/></h3>
<%
	Product pro = new Product();
	String[] list = pro.getProductList();
%>
<table border="${border }" bgcolor="${color }" width="200">
	<%for(int i=0; i<list.length; i++){ %>
		<tr>
			<td><%= list[i] %></td>
		</tr>
	<% } %>
</table>

<!-- WEB-INF/tags/juwon.tag -->