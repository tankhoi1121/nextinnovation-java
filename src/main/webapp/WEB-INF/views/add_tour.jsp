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
        <title>Add Tour</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <div class="row">
                        <div class="col mb-3">${message}</div>
                    </div>
                    <form:form method="POST" action ="/nextinnovation/admin/add_tour" modelAttribute="tour" accept-charset="utf-8">
                        <div class="mb-3">
                            <div class="row">
                                <div class="col"><label for="idInput" class="form-label">Tour ID: </label></div>
                                <div class="col">
                                    <form:errors path="id" cssClass="text-danger"/>
                                </div>
                            </div>

                            <input name="id" id ="idInput" class="form-control" placeholder="exp: 12345"/>                            
                        </div>
                        <div class ="mb-3">
                            <div class="row">
                                <div class="col"><label class="form-label" for="nameInput">Tour Name: </label></div>
                                <div class="col">
                                    <form:errors path="name" cssClass="text-danger" />
                                </div>
                            </div>

                            <input  name ="name" class="form-control" id="nameInput" placeholder="Please input character not number"/>
                        </div>
                        <div class ="mb-3">
                            <div class="row">
                                <div class="col"><label class="form-label" for="seasonInput">Season: </label></div>
                                <div class="col">
                                    <form:errors path="season" cssClass="text-danger" />
                                </div>
                            </div>

                            <input  name ="season" class="form-control" id="seasonInput" placeholder="Please input character not number"/>
                        </div>
                        <div class ="mb-3">
                            <div class="row">
                                <div class="col"><label class="form-label" for="summaryScheduleInput">Summary Schedule: </label></div>
                                <div class="col">
                                    <form:errors path="summarySchedule" cssClass="text-danger" />
                                </div>
                            </div>

                            <input  name ="summarySchedule" class="form-control" id="summaryScheduleInput" placeholder="Please input character not number"/>
                        </div>
                        <div class ="mb-3">
                            <div class="row">
                                <div class="col"><label class="form-label" for="conditionRemoveTourInput">Condition Remove Tour: </label></div>
                                <div class="col">
                                    <form:errors path="conditionRemoveTour" cssClass="text-danger" />
                                </div>
                            </div>

                            <input name ="conditionRemoveTour" class="form-control" id="conditionRemoveTourInput" placeholder="Please input character not number"/>
                        </div>
                        <div class ="mb-3">
                            <div class="row">
                                <div class="col"><label class="form-label" for="serviceIncludeAndNotIncludeInput">Service Include And Not Include:</label></div>
                                <div class="col">
                                    <form:errors path="serviceIncludeAndNotInclude" cssClass="text-danger" />
                                </div>
                            </div>

                            <input  name ="serviceIncludeAndNotInclude" class="form-control" id="serviceIncludeAndNotIncludeInput" placeholder="Please input character not number"/>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Add"/>
                        </div>
                    </form:form>

                </div>
                <div class="col">
                    <a href="<c:url value= "/admin/add_tour_detail"/>" class="btn btn-primary">Detail</a>
                </div>
            </div>
        </div>
    </body>
</html>
