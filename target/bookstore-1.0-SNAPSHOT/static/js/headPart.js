/*主要是处理登录，注销和搜索书籍的功能*/
$(function () {
    var $searchButton = $("#searchButton");
    var $searchBox = $("#search_box");
    /*定义搜索函数*/
    searchAction = function(){
        if ($searchBox.val().trim() === ""){
            $searchButton.attr("href","");
        }else {
            $searchButton.attr("href","/book_system/pages/major/searchbook.html?searchBoxMessage=" + $searchBox.val().trim());
        }
    }
    /*定义注销用户操作的函数*/
    userCancel = function(){
        $.get("http://10.84.198.103:8080/book_system/UserServlet","action=userCancel",function (data) {},"json");
        window.location.href = "/book_system/";
    }
    /*定义用户登录状态的函数*/
    loginStatus = function (){
        $.post("http://10.84.198.103:8080/book_system/UserServlet","action=loginStatus",function (data) {
            if (data != null){
                $("#head_span_1").html(data.userName + "&nbsp;|&nbsp;<input type='button' onclick='userCancel()' style='border: none ;background-color: #f1fafc;outline: none;' value='退出'><style type='text/css'>#head_span_1 input:hover{cursor: pointer}</style>");
                $("#userAvatar").attr("src",data.avatar)
            }
        },"json");
    }
    /*页面加载完成后触发*/
    loginStatus();
    /*更换用户头像*/
    $("#userAvatar").click(function () {
        var flag = window.confirm("是否要上传新头像");
        if (flag == true){
            window.location.href = "/book_system/pages/afterlogin/avatar.html"
        }
    })
    /*搜索按钮触发*/
    $searchButton.click(function () {
       searchAction();
    })
    /*当点击回车键时执行搜索功能*/
    $searchBox.focus(function () {
        $(document).keydown(function (event) {
            if (event.keyCode === 13){
                $("#searchButton img").trigger("click");
            }
        })
    })
})
