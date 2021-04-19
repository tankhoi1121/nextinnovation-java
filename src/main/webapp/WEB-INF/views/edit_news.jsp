<%-- 
    Document   : edit_news
    Created on : Apr 19, 2021, 10:49:36 PM
    Author     : bruce_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
        <title>Edit News</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <form:form method="POST"  action ="/nextinnovation/admin/edit_news/${newsId}" modelAttribute="news">
                        <div class="mb-3">
                            <label for="contentInput" class="form-label">Content</label>
                            <textarea  name="content" class="form-group"  cols="10" rows="10"></textarea>
                        </div>
                        <input class="btn btn-primary" value="Edit" type="submit"/>
                    </form:form>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
