<%-- 
    Document   : add_tour
    Created on : Apr 16, 2021, 7:18:10 PM
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
        <title>Update Tour</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <div class="row">
                        <div class="col mb-3">${message}</div>
                    </div>
                    <form:form action="/nextinnovation/admin/tour/${tourId}" method="POST" modelAttribute="tour">
                        <legend>${info.name}</legend>                        
                        <div class ="mb-3">
                            <label class="form-label" for="nameInput">Tour Name: </label>
                            <input  name ="name" class="form-control" id="nameInput" placeholder="Please input character not number" value="${info.name}"/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label" for="seasonInput">Season: </label>
                            <input  name ="season" class="form-control" id="seasonInput" placeholder="Please input character not number" value="${info.season}"/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label" for="summaryScheduleInput">Summary Schedule: </label>
                            <input  name ="summarySchedule" class="form-control" id="summaryScheduleInput" placeholder="Please input character not number" value="${info.summarySchedule}"/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label" for="conditionRemoveTourInput">Condition Remove Tour: </label>
                            <input name ="conditionRemoveTour" class="form-control" id="conditionRemoveTourInput" placeholder="Please input character not number" value="${info.conditionRemoveTour}"/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label" for="serviceIncludeAndNotIncludeInput">Service Include And Not Include: </label>
                            <input  name ="serviceIncludeAndNotInclude" class="form-control" id="serviceIncludeAndNotIncludeInput" placeholder="Please input character not number" value="${info.serviceIncludeAndNotInclude}"/>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Update"/>
                        </div>
                    </form:form>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </body>
</html>
