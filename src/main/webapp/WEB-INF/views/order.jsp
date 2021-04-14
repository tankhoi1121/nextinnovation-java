<%-- 
    Document   : order
    Created on : Apr 12, 2021, 4:53:20 PM
    Author     : NguyenTan.Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
    </head>
    <body style="background-image: url('<c:url value="/resources/image/2431841.jpg"/>')">
        <div class="container-fluid" >            
            <div class = "row">
                <div class ="col-lg-4"></div>
                <div class="col-lg-4">
                    <form>
                        <div class="mb-3">
                            <label for="customerName" class="form-label text-light">Họ và tên</label>
                            <input type="text" class="form-control" id="customerName" name ="name">
                        </div>
                        <div class="mb-3">
                            <label for="customerAddress" class="form-label text-light">Địa chỉ</label>
                            <input type="text" class="form-control" id="customerAddress" name ="address">
                        </div>
                        <div class="mb-3">
                            <label for="customerPhone" class="form-label text-light">Địa chỉ</label>
                            <input type="text" class="form-control" id="customerPhone" name ="phone">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label text-light">Email</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                            <div id="emailHelp" class="form-text">Chúng tôi sẽ giữ email của bạn riêng tư</div>
                        </div>                            
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
                <div class ="col-lg-4"></div>
            </div>
        </div>

    </body>
</html>
