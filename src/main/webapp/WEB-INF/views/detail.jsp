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
        <title>Tour Details</title>
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
                                    Du lịch theo mùa
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="<c:url value="/tour/season/1"/>">Mùa xuân</a></li>
                                    <li><a class="dropdown-item" href="<c:url value="/tour/season/2"/>">Mùa hạ</a></li>
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
                                    <div class ="col"><label id="tourId">${tour.id}</label></div>
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
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col"><label>Giá tour:</label></div>
                                    <div class ="col"><label>${product.priceForAdult}</label></div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row">
                                    <div class ="col">
                                        <a href="<c:url value="/order/${tour.id}"/>">Đặt tour</a>
                                    </div>                                    
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
                        <table>
                            <c:forEach items="${ok}" var="item">
                                <c:forEach items="${item}" var="cv">
                                    <tr>
                                        <td><c:out value="${cv}"/></td>                                    
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                        </table>

                        <h4 id="list-item-5">Bình luận</h4>
                        <div class="row">
                            <div class = "col">
                                <div class="form-inline">
                                    <c:forEach items="${allCommentTour}" var= "item">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <label class="form-label text-primary">${item.commentator}</label>                                               
                                            </div>
                                            <div class="col-md-10">
                                                <label class="form-label">${item.content}</label>

                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div  class="form-inline">
                                    <div class ="form-control">
                                        <textarea id ="content" name="w3review" rows="4" cols="80" maxlength="1000" placeholder="we always appreciate your opinions about our product">
                                        </textarea>
                                    </div>
                                    <div class="form-control">
                                        <input type="text" id="commentor" placeholder="Please input your name"/>
                                    </div>
                                    <div class="form-control">
                                        <input type="button" class="btn btn--primary" onclick ="addComment()" value="Send"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 list-group">
                        <a class="list-group-item list-group-item-action" href="#list-item-1">Lịch trình</a>                       
                        <a class="list-group-item list-group-item-action" href="#list-item-5">Bình luận</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value ="/resources/js/main.js"/>"></script>
    </body>
</html>
