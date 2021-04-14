<%-- 
    Document   : detail
    Created on : Apr 7, 2021, 1:56:33 PM
    Author     : NguyenTan.Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>JSP Page</title>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
    </head>
    <body>
        <div class="container-fluid">
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
                                    Seasonal Travel
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Spring</a></li>
                                    <li><a class="dropdown-item" href="#">Summer</a></li>
                                    <li><a class="dropdown-item" href="#">Fall</a></li>
                                    <li><a class="dropdown-item" href="#">Winter</a></li>
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
            <div class="d-flex">
                <div class="row">
                    <c:forTokens items="/resources/image/Tower_of_Taipei_101.jpg,/resources/image/Yan_Ming_San.jpg,/resources/image/thac-nuoc-thap-phan.jpg"
                                 delims="," var="imageName">
                        <div class="col">                            
                            <image src = "<c:url value="${imageName}"/>" width = "250" height="250"/>
                        </div>
                    </c:forTokens>
                    <div class="col position-static">
                        <ul class="list-group">
                            <li class="list-group-item active">${tour.name}</li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Mã tour:</label></div>
                                    <div class ="col"><label>${tour.id}</label></div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Thời gian:</label></div>
                                    <div class ="col"><label>Call</label></div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Khởi hành:</label></div>
                                    <div class ="col"><label>Call</label></div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Vận Chuyển</label></div>
                                    <div class ="col"><label>Call</label></div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Xuất phát:</label></div>
                                    <div class ="col"><label>Call</label></div>
                                </div>
                            </li>
                        </ul>                        
                    </div>
                </div>
            </div>
            <div class="d-flex">
                <div class="row">
                    <div class="col-lg-10" data-spy="scroll" data-target="#list-example" data-offset="0">
                        <h4 id="list-item-1">Lịch trình</h4>
                        <p>${tour.summarySchedule}</p>
                        
                        <h4 id="list-item-2">X</h4>

                        <h4 id="list-item-3">X</h4>

                        <h4 id="list-item-4">X</h4>

                        <h4 id="list-item-5">Bình luận</h4>
                        <div class="row">
                            <div class = "col">
                                <ul class="list-group">
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Morbi leo risus</li>
                                    <li class="list-group-item">Porta ac consectetur ac</li>
                                    <li class="list-group-item">Vestibulum at eros</li>
                                </ul>
                                <form class="form-inline">
                                    <div class ="form-control">
                                        <textarea id="w3review" name="w3review" rows="4" cols="80" maxlength="1000">
                                        </textarea>
                                    </div>
                                    <div class="form-control">
                                        <a class="btn btn-primary" href="#">Send</a>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 list-group">
                        <a class="list-group-item list-group-item-action" href="#list-item-1">Lịch trình</a>
                        <a class="list-group-item list-group-item-action" href="#list-item-2">Item2</a>
                        <a class="list-group-item list-group-item-action" href="#list-item-3">Item 3</a>
                        <a class="list-group-item list-group-item-action" href="#list-item-4">Item 4</a>
                        <a class="list-group-item list-group-item-action" href="#list-item-5">Bình luận</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
