$(function () {
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth*75/100;
    var maxHeightWrap = maxHeight*40/100;
    var maxHeightBookShow =  maxHeight*80/100;
    $(".wrap").css({"height":maxHeightWrap});
    $("#promise").css({"top":maxHeightWrap+223});
    $("#hotSales").css({"width":maxWidth1});
    $("#hotSales").css({"top":maxHeightWrap+223+30});
    $("#hotSales").css({"height":maxHeightBookShow});
    /*热销书籍列表图片*/
    var $showHotSalesBooks1 = $(".showHotSalesBooks1");
    /*热销书籍列表名字*/
    var $bookName1 = $(".bookName1");
    /*热销书籍列表价格*/
    var $bookPrice1 = $(".bookPrice1");
    /*热销书籍列表销量*/
    var $bookSales1 = $(".bookSales1");
    /*热销书籍点击图片的连接*/
    var $showHotSalesBooksLink = $(".showHotSalesBooksLink");
    /*向服务器发送get请求，得到具体的书本信息*/
    $.get("bestSellerList",function (data) {
        if (data != null){
            for (var i in data){
                /*jquery对象底层实际上是一个dom数组，通过$bookName[下标]的方法可以取到每一个dom对象*/
                $showHotSalesBooks1[i].src = data[i].img_url;
                $bookName1[i].innerHTML = "<center>" + data[i].book_name + "</center>";
                $bookPrice1[i].innerText = "￥" + data[i].book_price;
                $bookSales1[i].innerText = "已卖出" + data[i].sales_volume + "件";
                $showHotSalesBooksLink[i].href = "static/pages/book_information.html?bookId="+data[i].book_id;
            }
        }
    },"json");

})