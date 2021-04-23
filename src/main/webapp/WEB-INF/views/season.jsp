<%-- 
    Document   : season
    Created on : Apr 15, 2021, 3:11:52 PM
    Author     : NguyenTan.Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Next_Innovation_Travel</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">                      
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Du lịch theo mùa
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="<c:url value="/tour/season/1"/>">Mùa hạ</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/tour/season/2"/>">Mùa xuân</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/tour/season/3"/>">Mùa thu</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/tour/season/4"/>">Mùa đông</a></li>
                            </ul>
                        </li>                        
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class ="d-flex">
                <div class="row">
                    <div class ="col">
                        <c:if test ="${info != null}">
                            <c:forEach items="${info}" var ="item">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="<c:url value="/resources/image/Tower_of_Taipei_101.jpg"/>" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">${item.name}</h5>
                                        <div class="card-text">
                                            <div class="row">
                                                <div class="col">
                                                    <label><i class="far fa-clock"></i></label>
                                                </div>
                                                <div class="col">
                                                    <label>5 ngày 4 đêm</label>  
                                                </div>                                        
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <label><i class="far fa-calendar-alt"></i></label>
                                                </div>
                                                <div class="col">
                                                    <label></label>  
                                                </div>                                        
                                            </div>
                                            <div class="row">                                        
                                                <div class="col alert alert-danger">
                                                    <label>Call</label>  
                                                </div>                                        
                                            </div>
                                        </div>
                                        <a href="<c:url value="/td/${item.id}"/>" class="btn btn-primary">Chi tiết</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
