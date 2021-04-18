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
    fetch("/admin/add_comment_tour", {
        method: "POST",
        headers: {"Content-type": "application/json;charset=UTF-8"},
        body: JSON.stringify(tour),
    }).then(function (res) {
        console.log(res);
        location.reload();
    })
}
