<%-- 
    Document   : all_news
    Created on : Apr 19, 2021, 10:52:19 PM
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
        <table class="table">
            <c:forEach items="${allnews}" var = "item">
                <tr>
                    <td>${item.id}</td>                    
                    <td><a class="btn btn--primary" href="<c:url value="/admin/edit_news/${item.id}"/>">Edit</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
