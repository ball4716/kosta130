<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- replyList.jsp --%>
[
	<c:forEach items="${list }" var="reply" varStatus="stat">
		{
		no:${reply.no },
		name:'${reply.name }',
		content:'${reply.content }'
		}
		<c:if test="${stat.count < list.size() }">,</c:if>
	</c:forEach>
]

