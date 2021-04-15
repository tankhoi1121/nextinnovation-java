<%-- 
    Document   : individual_staff
    Created on : Apr 15, 2021, 1:37:03 PM
    Author     : NguyenTan.Khoi
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
        <title>JSP Page</title>
    </head>
    <body>
        <form:form action="/nextinnovation/admin/staff/${staffId}" method="POST" modelAttribute="staff">
            <fieldset id = "fs" >
                <legend>${info.name}</legend>
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Name</label>
                    <input type="text" name="name" id="nameInput" class="form-control" value="${info.name}">
                </div>
                <div class="mb-3">
                    <label for="addressInput" class="form-label">Address</label>
                    <input type="text" name="address" id="addressInput" class="form-control" value = "${info.address}">
                </div>
                <div class="mb-3">
                    <label for="phoneInput" class="form-label">Phone</label>
                    <input type="text" name="phone" id="phoneInput" class="form-control" value = "${info.phone}">
                </div>
                <div class="mb-3">
                    <label for="emailInput" class="form-label">Email</label>
                    <input type="text" name="email" id="emailInput" class="form-control" value="${info.email}">
                </div>
                <div class="mb-3">
                    <label for="departmentInput" class="form-label">Department</label>
                    <input type="text" name="department" id="departmentInput" class="form-control" value ="${info.department}">
                </div>
                <div class="mb-3">
                    <label for="roleInput" class="form-label">Role</label>
                    <input type="text" name="role" id="roleInput" class="form-control" value = "${info.role}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </fieldset>                
            <p>${message}</p>
        </form:form>        
    </body>
</html>
