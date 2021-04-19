<%-- 
    Document   : all_news_1
    Created on : Apr 19, 2021, 11:07:48 PM
    Author     : bruce_
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${allnews}" var="item">
            <div class="card" style="width: 18rem;">
                <div class="card-body">                    
                    <p class="card-text">${item.content}</p>
                    <a class="btn btn--primary" href="<c:url value="/news_detail/${item.id}"/>">Detail</a>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
