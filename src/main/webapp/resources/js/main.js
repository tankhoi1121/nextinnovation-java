/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//function getDataComment() {
//    let commentor = document.getElementById("commentor");
//    let content = document.getElementById("content");
//    let tourId = document.getElementById("tourId");
//    let email = ""
//    var tour = {
//        commentator: commentor.value,
//        emailCommentator: email,
//        content: content.value,
//        tourId: tourId.innerHTML
//    }
//    return tour;
//}


var count = 0;
var listTD = [];


function addComment() {
    let commentor = document.getElementById("commentor");
    let content = document.getElementById("content");
    let tourId = document.getElementById("tourId");
    let email = ""
    var tour = {
        commentator: commentor.value,
        emailCommentator: email,
        content: content.value,
        tourId: tourId.innerHTML
    }
    fetch("/nextinnovation/admin/add_comment_tour", {
        method: "POST",
        headers: {"Content-type": "application/json;charset=UTF-8"},
        body: JSON.stringify(tour),
    }).then(function (res) {
        return res.json();

    }).then(data => {
        console.log(data);
        location.reload();
    });
}

function getValue() {
//    let tourId = document.getElementById("tourId");
//    let header = document.getElementById("header");
//    let description = document.getElementById("description");
    var getEle = {
        tourId: document.getElementById("tourId"),
        header: document.getElementById("header"),
        description: document.getElementById("description")
    }

    var td = {
        tourId: getEle.tourId.value,
        header: getEle.header.value,
        description: getEle.description.value
    }


    count = count + 1;

    return td;
}




function addTourDetailToList(listTD) {
    listTD.push(getValue());
    // return listTD;
}

function x() {
    var getEle = {
        tourId: document.getElementById("tourId"),
        header: document.getElementById("header"),
        description: document.getElementById("description")
    };
    getEle.tourId.value = "";
    getEle.header.value = "";
    getEle.description.value = "";
}

async function sendListTourDetail(listTD) {

    fetch("/nextinnovation/admin/add_tour_detail", {
        method: "POST",
        headers: {"Content-type": "application/json;charset=UTF-8"},
        body: JSON.stringify(listTD),
    }).then(function (res) {
        return res.json();
    }).then(data => {
        console.log(data);
    })
    x();
    //location.reload();
}

