<%-- 
    Document   : statictis_revernue
    Created on : Apr 21, 2021, 10:17:25 AM
    Author     : bruce_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics Revenue</title>
        <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" media="all"/>
        <script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Next_Innovation_Travel</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>                
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <div class="row">
                        <div class= "col">
                            <label>From Date</label>
                            <input type="date" id ="fromDate" />
                        </div>
                        <div class= "col">
                            <label>To Date</label>
                            <input type="date" id ="toDate" />
                        </div>
                        <div class= "col">
                            <button class="btn btn-primary" onclick="getRevenue()">Search Revenue</button>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <table class ="table-active">
                        <tr>
                            <td>Total Revenue:</td>
                            <td id="totalRevenue"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <!--            <canvas id="bar-chart" width="800" height="450"></canvas>
                        <script>
                            new Chart(document.getElementById("bar-chart"), {
                                type: 'bar',
                                data: {
                                    labels: ["Jan", "Feb", "Mar", "April", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                    datasets: [
                                        {
                                            label: "Population (millions)",
                                            backgroundColor: ["#3e95cd"],
                                            data: [2478, 5267, 734, 784, 433, 5000, 7455, 3334, 1547, 8744, 1111, 3649]
                                        }
                                    ]
                                },
                                options: {
                                    legend: {display: false},
                                    title: {
                                        display: true,
                                        text: 'Revenue a whole of the year'
                                    }
                                }
                            })
                        </script>-->
            <script>
                function  getRevenue() {
                    var stat = {
                        from: document.getElementById("fromDate").value,
                        to: document.getElementById("toDate").value
                    };
                    var form = document.getElementById("fromDate").value;
                    var to = document.getElementById("toDate").value;
                    let totalRevenue = document.getElementById("totalRevenue");
                    var list = [];
                    list.push(form);
                    list.push(to);
                    fetch("/nextinnovation/admin/statistics_revenue", {
                        method: "POST",
                        headers: {"Content-type": "application/json;charset=UTF-8"},
                        body: JSON.stringify(list)
                    }).then(function (res) {
                        return res.json();
                    }).then(data => {
//                        console.log(data);
                        totalRevenue.innerHTML = data;
                    })
                }
            </script>
        </div>
    </body>
</html>
