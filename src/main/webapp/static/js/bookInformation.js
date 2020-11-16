$(function () {
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth*75/100;
    var maxHeight1 = maxHeight*50/100;
    $("#bookInformation").css({"width":maxWidth1});
    $("#bookInformation").css({"height":maxHeight1});
    $("#bookInformationDetail").css({"width":maxWidth1});
    $("#bookInformationDetail").css({"top":maxHeight1+224});
    $("#bookInformationIntroduce").css({"width":maxWidth1});
    $("#bookInformationIntroduce").css({"top":maxHeight1+425});
    /*获取当前地址栏的链接值*/
    var windowLocalStorage = window.location.href;
    /*减少商品数量按钮*/
    var $reduceNumber = $("#bookInformationBuyCount input:eq(0)");
    /*数量输入框*/
    var $inputNumber = $("#bookInformationBuyCount input:eq(1)");
    /*增加商品数量按钮*/
    var $addNumber = $("#bookInformationBuyCount input:eq(2)");
    /*立即购买*/
    var $buyNow = $("#bookInformationBuy input:eq(0)");
    /*加入购物车*/
    var $addCar = $("#bookInformationBuy input:eq(1)");
    var buyCount = 1;
    var stock;
    /*截取地址栏字符串，将id后面的值截取出来*/
    var bookId = windowLocalStorage.split("?")[1].split("=")[1];
    $.get("searchOneBookInformation","bookId="+bookId,function (data) {
        if (data != null){
            stock = data.stock;
            $("#bookInformationImg").attr("src",data.img_url)
            $("#bookInformationName").text(data.book_name);
            $("#bookInformationAuthor").html("<span style='color: gray'>作者：</span>"+data.book_author);
            $("#bookInformationPrice").html("<span style='color: gray'>售价：</span>"+"<span style='color: red;font-size: 40px'>￥"+data.book_price+"</span>");
            $("#bookInformationSales").html("<span style='color: gray'>销量：</span>"+data.sales_volume);
            $("#bookInformationStock").html("<span style='color: gray'>库存："+data.book_stock+"</span>");
            $("#pageNumber").text("页数："+data.page_number);
            $("#bookIsbn").text("ISBN："+data.book_isbn);
            $("#bookName").text("书名："+data.book_name);
            $("#publishHouse").text("出版地："+data.publish_house);
            $("#publishTime").text("出版日期："+data.publish_time);
            $("#bookAuthor").text("作者："+data.book_author);
            $("#bookIntroduce").text(data.book_introduce);
            /*当库存小于1,等于1，大于1时*/
            if (stock < 1){
                $reduceNumber.attr("disabled",true);
                $addNumber.attr("disabled",true);
                $inputNumber.attr("disabled",true);
                $addCar.attr("disabled",true);
                $buyNow.attr("disabled",true);
            }else if (stock == 1){
                $reduceNumber.attr("disabled",true);
                $addNumber.attr("disabled",true);
                $inputNumber.attr("disabled",true);
            }else {
                $reduceNumber.attr("disabled",true);
            }
        }
    },"json");
    //点击-号
    $reduceNumber.click(function () {
        $addNumber.attr("disabled",false);
        $inputNumber.val(--buyCount);
        if (buyCount == 1){
            $reduceNumber.attr("disabled",true);
        }
    })
    //点击+号
    $addNumber.click(function () {
        $reduceNumber.attr("disabled",false)
        $inputNumber.val(++buyCount);
        if (buyCount >= stock){
            $addNumber.attr("disabled",true);
        }
    })
    /*当输入数量框失去焦点*/
    $inputNumber.blur(function () {
        if ($inputNumber.val() >1 && $inputNumber.val() < stock){
            buyCount = $inputNumber.val();
            $reduceNumber.attr("disabled",false);
            $addNumber.attr("disabled",false);
        }else if ($inputNumber.val() == 1){
            buyCount = 1;
            $reduceNumber.attr("disabled",true);
            $addNumber.attr("disabled",false);
        }else if ($inputNumber.val() == stock){
            buyCount = stock;
            $reduceNumber.attr("disabled",false);
            $addNumber.attr("disabled",true);
        } else if ($inputNumber.val() > stock){
            buyCount = 1;
            $reduceNumber.attr("disabled",true);
            $addNumber.attr("disabled",false);
            alert("库存数量不足！");
        }else {
            buyCount = 1;
            $reduceNumber.attr("disabled",true);
            $addNumber.attr("disabled",false);
            alert("输入有误！");
        }
        $inputNumber.val(buyCount);
    })
    //点击直接购买
    $buyNow.click(function () {
        window.location.href = "/bookstore/static/pages/user/receipt_information_book.html?orderNumber="+$inputNumber.val()+"&bookId="+bookId;
    })
    //点击加入购物车
    $addCar.click(function () {
        $.post("user/addOneItemToCar","bookId="+bookId+"&inputNumber="+$inputNumber.val(),function (data) {
            if (data != null){
                alert(data);
            }
        },"text");
    })
})