<%-- 
    Document   : add_staff
    Created on : Apr 15, 2021, 9:46:39 AM
    Author     : NguyenTan.Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
    </head>
    <body>   
        <form:form method="POST" action ="/nextinnovation/admin/add_staff" modelAttribute="staff" accept-charset="utf-8">
            <!<!-- Name -->
            <div class="mb-3">
                <div class="row">
                    <div class="col">
                        <label for="nameInput" class="form-label">Name</label>
                    </div>
                    <div class="col">
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                </div>
                <input name="name" type="text" class="form-control"/>
            </div>
            <!<!-- Address -->
            <div class="mb-3">
                <div class="row">
                    <div class="col">
                        <label for="addressInput" class ="form-label">Address</label>
                    </div>
                    <div class="col">
                        <form:errors path="address" cssClass="text-danger"/>
                    </div>
                </div>
                <input name="address" type="text" class="form-control"/>
            </div>
            <!<!-- Phone -->
            <div class = "mb-3">
                <div class="row">
                    <div class="col">
                        <label for="phoneInput" class="form-label">Phone</label>
                    </div>
                    <div class="col">
                        <form:errors path="phone" cssClass="text-danger"/>
                    </div>
                </div>

                <input name = "phone" type="text" class="form-control"/>
            </div>
            <!<!-- Email -->
            <div class = "mb-3">
                <div class="row">
                    <div class="col">
                        <label for="emailInput" class="form-label">Email</label>
                    </div>
                    <div class="col">
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                </div>

                <input name="email" type="text" class="form-control"/>
            </div>
            <!<!-- Department -->            
            <div class = "mb-3">
                <div class="row">
                    <div class="col">
                        <label for="departmentInput" class="form-label">Department</label>
                    </div>
                    <div class="col">
                        <form:errors path="department" cssClass="text-danger"/>
                    </div>
                </div>                
                <input name="department" type="text" class="form-control"/>
            </div>
            <!<!-- Role -->
            <div class = "mb-3">
                <div class="row">
                    <div class="col">
                        <label for="roleInput" class ="form-label">Role</label>
                    </div>
                    <div class="col">
                        <form:errors path="role" cssClass="text-danger"/>
                    </div>
                </div>
                <input name="role" type="text" class="form-control"/>
            </div>
            <div class="mb-3">
                <input type="submit" value="Add"/>
            </div>
        </form:form>
        <p>${message}</p>   
    </body>
</html>
