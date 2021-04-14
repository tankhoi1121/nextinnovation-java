<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
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
                                <li><a class="dropdown-item" href="#">Mùa xuân</a></li>
                                <li><a class="dropdown-item" href="#">Mùa hạ</a></li>
                                <li><a class="dropdown-item" href="#">Mùa thu</a></li>
                                <li><a class="dropdown-item" href="#">Mùa đông</a></li>
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
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="<c:url value="/resources/image/Tower_of_Taipei_101.jpg"/>" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Du lịch Đài Loan mùa hoa Anh Đào 5 ngày 4 đêm từ Sài Gòn giá tốt 2020</h5>
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
                                          <label>07/04/2020</label>  
                                        </div>                                        
                                    </div>
                                    <div class="row">                                        
                                        <div class="col alert alert-danger">
                                          <label>10,999,000đ</label>  
                                        </div>                                        
                                    </div>
                                </div>
                                <a href="<c:url value="/detail"/>" class="btn btn-primary">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>