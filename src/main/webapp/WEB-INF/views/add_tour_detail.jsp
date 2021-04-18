<%-- 
    Document   : add_tour_detail
    Created on : Apr 18, 2021, 8:06:12 PM
    Author     : bruce_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Tour Details</title>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <div>
                        <div class="mb-3">
                            <label class="form-label">TourID</label>
                            <input id ="tourId" type="text" class="form-control"  value=""/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label">header</label>
                            <input id="header" type="text" class="form-control" value=""/>
                        </div>
                        <div class ="mb-3">
                            <label class="form-label">description</label>
                            <textarea id="description" class="form-control"></textarea>
                        </div>
                        <div class="mb-3">
                            <div class="row">
                                <div class="col">
                                    <input type="button" class="btn  btn-dark" onclick="addTourDetailToList(listTD)"  value="Add"/>
                                </div>
                                <div class="col">
                                    <input type ="button" class="btn  btn-success"  onclick = "sendListTourDetail(listTD)"value="Complete"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col"></div>
            </div>
        </div>
        <script src="<c:url value ="/resources/js/main.js"/>"></script>
    </body>
</html>
