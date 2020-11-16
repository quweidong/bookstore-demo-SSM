$(function () {
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth * 75 / 100;
    var maxHeight1 = maxHeight*75/100;
    //当前的页数
    var nowPage = 1;
    $("#carNav").css({"width": maxWidth1});
    $("#carList").css({"width": maxWidth1});
    $("#carList").css({"height": maxHeight1});
    $("#carPage").css({"width": maxWidth1});
    $("#carPage").css({"top": maxHeight1 + 293})
    $("#pay").css({"width": maxWidth1});
    $("#pay").css({"top": maxHeight1 + 360});

    /*一个清空列表数据的函数*/
    hideElement = function() {
        for (var i = 0; i < 5; i++) {
            /*jquery对象底层实际上是一个dom数组，通过$bookName[下标]的方法可以取到每一个dom对象*/
            $(".carItemImg")[i].src = "";
            $(".carItemName")[i].innerHTML = "";
            $(".carItemAuthor")[i].innerHTML = "";
            $(".carItemSinglePrice")[i].innerHTML = "";
            $(".carItemInputNumber")[i].innerText = "";
            $(".carItemTotalPrice")[i].innerHTML = "";
            $(".carItemButton")[i].type = "hidden";
            $(".hiddenPart")[i].value="";
        }
    }
    //查询书籍信息以及关于分页的函数
    synthesis = function(currentPage){
        $.ajaxSettings.async = false;
        $.post("user/selectOneCarAllItems",function (data) {
            //前端分页当数量大于5时，下一页有效
            if (data != null){
                $("#goToPay").attr("disabled",false);
                var right = data.length;
                if (data.length > 5){
                    right = currentPage * 5;
                    $("#summaryPage").text(parseInt((data.length-1)/5 + 1));
                    $("#nextPage").attr("disabled",false);
                    if (currentPage == parseInt((data.length-1)/5 + 1)){
                        right = data.length;
                        $("#nextPage").attr("disabled",true);
                    }
                }else {
                    $("#summaryPage").text(1);
                    $("#nextPage").attr("disabled",true);
                }
                var j = -1;
                for (var i=(currentPage-1)*5;i<right;i++){
                    j++;
                    $.get("searchOneBookInformation","bookId=" + data[i].book_id,function (message) {
                        if (message != null){
                            $(".carItemImg")[j].src = message.img_url;
                            $(".carItemName")[j].innerHTML = message.book_name;
                            $(".carItemAuthor")[j].innerHTML = message.book_author;
                            $(".carItemSinglePrice")[j].innerHTML = message.book_price;
                        }
                    },"json");
                    $(".carItemInputNumber")[j].innerText = data[i].single_number+"(件)";
                    $(".carItemTotalPrice")[j].innerHTML = data[i].single_price;
                    $(".carItemButton")[j].type = "button";
                    $(".hiddenPart")[j].value = data[i].book_id;
                }
            }
            if (data == ""){
                $("#goToPay").attr("disabled",true);
            }
        },"json");
        $.ajaxSettings.async = true;
    }
    //付款区域的函数
    pay=function(){
        $.post("user/selectOneCarInformation",function (data) {
            if (data != null){
                $("#goodsSum").text("共计"+data.total_number+"件商品");
                $("#buyPrice").html("总计金额："+"<span style='color: red;font-size: 30px'>￥"+data.total_price+"</span>")
            }
        },"json");
    }
    //当页面加载完成后执行
    hideElement();
    $("#lastPage").attr("disabled",true);
    $("#nextPage").attr("disabled",true);
    $("#currentPage").text(1);
    $("#summaryPage").text(1);
    synthesis(1);

    pay();

    //点击上一页执行的功能
    $("#lastPage").click(function () {
        hideElement();
        nowPage --;
        $("#currentPage").text(nowPage);
        synthesis(nowPage);
        if (nowPage == 1){
            $("#lastPage").attr("disabled",true);
        }
    })
    //点击下一页执行的功能
    $("#nextPage").click(function () {
        hideElement();
        nowPage ++;
        $("#currentPage").text(nowPage);
        synthesis(nowPage);
        $("#lastPage").attr("disabled",false);
    })
    deleteItem = function (bookId) {
        var flag = window.confirm("是否确定将该商品移出购物车");
        if (flag == true) {
            //删除后重新定位到第一页
            $.ajaxSettings.async = false;
            $.post("user/deleteOneItemFromCar", "bookId=" + bookId, function (data) {

            }, "json");
            $.ajaxSettings.async = true;
            hideElement();
            nowPage = 1;
            $("#currentPage").text(1);
            synthesis(nowPage);
            $("#lastPage").attr("disabled", true);
            pay();
        }
    }
    $("#goToPay").click(function () {
        window.location.href="static/pages/user/receipt_information_car.html";
    })
})