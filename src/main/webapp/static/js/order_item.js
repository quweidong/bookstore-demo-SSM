$(function () {
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth * 75 / 100;
    var maxHeight1 = maxHeight*75/100;
    $("#orderItemNav").css({"width": maxWidth1});
    $("#orderItemList").css({"width": maxWidth1});
    /*获取当前地址栏的链接值*/
    var windowLocalStorage = window.location.href;
    /*截取地址栏字符串，将orderNo后面的值截取出来*/
    var orderNo = windowLocalStorage.split("?")[1].split("=")[1];
    $.post("user/selectOneOrderAllItems","orderNo="+orderNo,function (data) {
        if (data != null){
            for (var i in data){
                $("#orderItemList").append("<div class='itemDetail'>\n" +
                    "        <img class='itemImg' src='"+data[i].book_img+"'>\n" +
                    "        <span class='itemName'>"+data[i].book_name+"</span>\n" +
                    "        <span class='itemNumber'>"+data[i].item_number+"（件）</span>\n" +
                    "        <span class='itemPrice'>￥"+data[i].item_price+"</span>\n" +
                    "    </div>");
            }
        }
    },"json");
})