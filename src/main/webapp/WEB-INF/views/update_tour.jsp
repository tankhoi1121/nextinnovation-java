<%-- 
    Document   : update_tour
    Created on : Apr 16, 2021, 11:36:49 PM
    Author     : bruce_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Tour</title>
    </head>
    <body>
        <div class="container-fluid">
            <c:forEach items="${allTourId}" var="item">
                <div class ="row">
                    <div class="col-sm-4">${item.id}</div>
                    <div class="col-sm-4"><a class="btn btn-primary" href="<c:url value="/admin/tour/${item.id}"/>">Edit</a></div>
                </div>
            </c:forEach>

        </div>
    </body>
</html>
