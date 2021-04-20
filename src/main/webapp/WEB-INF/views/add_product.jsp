<%-- 
    Document   : add_product
    Created on : Apr 20, 2021, 7:42:10 PM
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
        <title>Add Product</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <form:form method="POST"   action ="/nextinnovation/admin/add_product" modelAttribute="product">
                        <div class="mb-3">
                            <label>Tour ID:</label>
                            <input type="text" value="" name="tourId"/>
                        </div>
                        <div class="mb-3">
                            <label>Price For Children: </label>
                            <input type="text" value="" name="priceForChildren"/>
                        </div>
                        <div class="mb-3">
                            <label>Price For Adult</label>
                            <input type="text" value="" name="priceForAdult"/>
                        </div>
                        <div class= "mb-3">
                            <input type="submit" value= "Add" class ="btn btn-primary"/>
                        </div>
                    </form:form>
                </div>
                <div class="col-md-4"></div>

            </div>
        </div>
    </body>
</html>
