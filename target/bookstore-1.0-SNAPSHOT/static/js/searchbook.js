$(function () {
    /*定义一个标识，默认为1*/
    var flag = 1;
    /*当前页面的页数，默认为第一页*/
    var pageNumber = 1;
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth*75/100;
    var maxHeight1 = maxHeight*250/100;
    $("#searchBooksList").css({"width":maxWidth1});
    $("#searchBooksList").css({"height":maxHeight1});
    $("#searchBookPage").css({"width":maxWidth1});
    $("#searchBookPage").css({"top":maxHeight1+293})
    var windowLocation = window.location.href;
    var searchBoxMessage = windowLocation.split("?")[1].split("=")[1];
    /*要先通过转码将中文的地址栏url转换成中文*/
    $.get("searchBooksNumberByMessage","searchBoxMessage="+decodeURIComponent(searchBoxMessage),function (data) {
        $("#searchBooksResult").html("共为您查询到&nbsp;"+"<a style='color: red;font-size: 17px'>"+data+"</a>"+"&nbsp;条相关结果！");
        if (data>=1){
            $("#summaryPage").text((data-1)/10 + 1);
        }else {
            $("#summaryPage").text(1);
        }
        /*只要数量小于等于10，下一页按钮失效*/
        if (data<=10){
            $("#nextPage").attr({"disabled":true});
        }
    },"text")
    /*显示当前的页数*/
    $("#currentPage").text(pageNumber);
    /*定义函数显示每本书籍的陈列信息*/
    synthesis = function(arrangeMethod,arrangeField,pageNumber){
        $.get("searchBooksByMessage","searchBoxMessage="+decodeURIComponent(searchBoxMessage)+"&arrangeMethod="+arrangeMethod+"&arrangeField="+arrangeField+"&pageNumber="+pageNumber,function (data) {
            if (data != null){
                for (var i in data){
                    /*jquery对象底层实际上是一个dom数组，通过$bookName[下标]的方法可以取到每一个dom对象*/
                    $(".searchBookLink")[i].style.setProperty('display','');
                    $(".searchBookImg")[i].src = data[i].img_url;
                    $(".searchBookName")[i].innerHTML = data[i].book_name;
                    $(".searchBookPrice")[i].innerText = "￥" + data[i].book_price;
                    $(".searchBookAuthor")[i].innerHTML="<a style='color: darkgray'>作者：</a>"+data[i].book_author;
                    $(".searchBookPublishHouse")[i].innerHTML="<a style='color: darkgray'>出版社：</a>"+data[i].publish_house;
                    $(".searchBookPublishTime")[i].innerHTML="<a style='color: darkgray'>出版时间：</a>"+data[i].publish_time.split(",")[1]+"年"+data[i].publish_time.split(",")[0]+"日";
                    $(".searchBookSales")[i].innerHTML = "已卖出<span style='color: red;font-size: 15px'>" + data[i].sales_volume + "</span>件";
                    $(".searchBookLink")[i].href = "static/pages/book_information.html?bookId="+data[i].book_id;
                }
            }
        },"json")
    }
    /*一个清空列表数据的函数*/
    hideElement = function(){
        for (var i=0;i<10;i++){
            /*jquery对象底层实际上是一个dom数组，通过$bookName[下标]的方法可以取到每一个dom对象*/
            $(".searchBookLink")[i].style.setProperty('display','none');
            $(".searchBookImg")[i].src = "";
            $(".searchBookName")[i].innerHTML = "";
            $(".searchBookPrice")[i].innerText = "";
            $(".searchBookAuthor")[i].innerHTML = "";
            $(".searchBookPublishHouse")[i].innerHTML = "";
            $(".searchBookPublishTime")[i].innerHTML = "";
            $(".searchBookSales")[i].innerText = "";
        }
    }
    /*页面加载完成之后直接执行此函数*/
    synthesis(null,null,pageNumber);
    /*上一页失效*/
    $("#lastPage").attr({"disabled":true});
    /*点击上一页和下一页*/
    $("#lastPage").click(function () {
        hideElement();
        if (flag == 1){
            synthesis(null,null,--pageNumber);
            $("#currentPage").text(pageNumber);
        }else if (flag == 2){
            synthesis("asc","book_price",--pageNumber);
            $("#currentPage").text(pageNumber);
        }else if (flag == 3){
            synthesis("desc","book_price",--pageNumber)
            $("#currentPage").text(pageNumber);
        }else if (flag == 4){
            synthesis("desc","sales_volume",--pageNumber);
            $("#currentPage").text(pageNumber);
        }else {
            synthesis("asc","sales_volume",--pageNumber);
            $("#currentPage").text(pageNumber);
        }
        if (1 == pageNumber){
            $("#lastPage").attr({"disabled":true});
        }
        $("#nextPage").attr({"disabled":false});
    })
    $("#nextPage").click(function () {
        hideElement();
        if (flag == 1){
            synthesis(null,null,++pageNumber);
            $("#currentPage").text(pageNumber);
        }else if (flag == 2){
            synthesis("asc","book_price",++pageNumber);
            $("#currentPage").text(pageNumber);
        }else if (flag == 3){
            synthesis("desc","book_price",++pageNumber)
            $("#currentPage").text(pageNumber);
        }else if (flag == 4){
            synthesis("desc","sales_volume",++pageNumber);
            $("#currentPage").text(pageNumber);
        }else {
            synthesis("asc","sales_volume",++pageNumber);
            $("#currentPage").text(pageNumber);
        }
        if (parseInt($("#summaryPage")[0].innerText) == pageNumber){
            $("#nextPage").attr({"disabled":true});
        }
        $("#lastPage").attr({"disabled":false});
    })
    /*当点击综合后调用此函数*/
    $("#searchBooksSynthesis").click(function () {
        /*点击综合后flag变为1*/
        flag = 1;
        pageNumber = 1;
        $("#currentPage").text(pageNumber);
        synthesis(null,null,pageNumber);
        $("#lastPage").attr({"disabled":true});
        if (parseInt($("#summaryPage")[0].innerText) != 1){
            $("#nextPage").attr({"disabled":false});
        }
    })
    /*当点击价格从低到高或者从高到低时*/
    $("#searchBooksByPrice").click(function () {
        pageNumber = 1;
        $("#currentPage").text(pageNumber);
        if ($("#searchBooksByPrice").val()==="价格从低到高"){
            /*当点击价格从低到高时*/
            flag = 2;
            $("#searchBooksByPrice").val("价格从高到低");
            synthesis("asc","book_price",pageNumber);
            $("#lastPage").attr({"disabled":true});
            if (parseInt($("#summaryPage")[0].innerText) != 1){
                $("#nextPage").attr({"disabled":false});
            }
        }else {
            /*当点击价格从高到低时*/
            flag = 3;
            $("#searchBooksByPrice").val("价格从低到高");
            synthesis("desc","book_price",pageNumber);
            $("#lastPage").attr({"disabled":true});
            if (parseInt($("#summaryPage")[0].innerText) != 1){
                $("#nextPage").attr({"disabled":false});
            }
        }
    })
    /*当点击销量从高到低或者从低到高时*/
    $("#searchBooksByVolume").click(function () {
        pageNumber = 1;
        $("#currentPage").text(pageNumber);
        if ($("#searchBooksByVolume").val()==="销量从高到低"){
            /*当点击销量从高到低时*/
            flag = 4;
            $("#searchBooksByVolume").val("销量从低到高");
            synthesis("desc","sales_volume",pageNumber);
            $("#lastPage").attr({"disabled":true});
            if (parseInt($("#summaryPage")[0].innerText) != 1){
                $("#nextPage").attr({"disabled":false});
            }
        }else {
            /*当点击销量从低到高时*/
            flag = 5;
            $("#searchBooksByVolume").val("销量从高到低");
            synthesis("asc","sales_volume",pageNumber);
            $("#lastPage").attr({"disabled":true});
            if (parseInt($("#summaryPage")[0].innerText) != 1){
                $("#nextPage").attr({"disabled":false});
            }
        }
    })
})