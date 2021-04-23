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
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                    <div class= "text-success" id= "successStatus"></div>
                    <div class = "mb-3">
                        <label class= "text-light">Tour Id:</label>
                        <label class= "text-light" id= "tourId">${product.tourId}</label>
                        <label class="invisible" id="pid">${product.id}</label>
                    </div>
                    <div class = "mb-3">
                        <label class="text-light">Quality:</label>
                        <input type="text" id="qty" value ="1"  onchange="check()"/>
                    </div>                    
                    <div class = "mb-3">
                        <label class="text-light">Name:</label>
                        <input type="text" id="name" value =""/>
                    </div>
                    <div class = "mb-3">
                        <label class="text-light">Address:</label>
                        <input type="text" id="address" value =""/>
                    </div>
                    <div class = "mb-3">
                        <label class="text-light">Phone:</label>
                        <input type="text" id="phone" value =""/>
                    </div>
                    <div class = "mb-3">
                        <label class="text-light">Email:</label>
                        <input type="text" id="email" value =""/>
                    </div>
                    <div class = "mb-3">
                        <button onclick ="Send()">Add</button>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5>Total Price:</h5><br/>
                            <h1 class="card-title" id= "totalprice">${product.priceForAdult}</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const priceUnit = parseInt(document.getElementById("totalprice").innerHTML);
            check = () => {
                let totalpriceEle = document.getElementById("totalprice");
                let totalPrice = parseInt(document.getElementById("qty").value) * priceUnit;
                totalpriceEle.innerHTML = totalPrice.toString();
                totalPrice = 0;
            }
            Send = () =>
            {
                let pid = document.getElementById("pid").innerHTML;
                let tourId = document.getElementById("tourId").innerHTML;
                let name = document.getElementById("name").value;
                let address = document.getElementById("address").value;
                let phone = document.getElementById("phone").value;
                let email = document.getElementById("email").value;
                var customer = {
                    name: name,
                    address: address,
                    phone: phone,
                    email: email
                };
                var product = {
                    tourId: tourId,
                    priceForAdult: priceUnit,
                    priceForChilren: 0.9 * priceUnit,
                };
                var qty = {qty: document.getElementById("qty").value};

                var list = [];
                list.push(JSON.stringify(customer));
                list.push(JSON.stringify(product));
                list.push(JSON.stringify(qty));
                fetch("/nextinnovation/order_confirm", {
                    method: "POST",
                    headers: {"Content-type": "application/json;charset=UTF-8"},
                    body: JSON.stringify(list)
                }).then(function (res) {
                    if (res.status == 200) {
                        document.getElementById("successStatus").innerHTML = "Success";
                        setTimeout(() => {
                            location.reload();
                        }, 5000);
                    }
                })
            }
        </script>

    </body>
</html>
