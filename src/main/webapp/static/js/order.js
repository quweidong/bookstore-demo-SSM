$(function () {
    /*获取当前屏幕的宽度*/
    var maxWidth = window.screen.width;
    /*获取当前屏幕的高度*/
    var maxHeight = window.screen.height;
    var maxWidth1 = maxWidth * 75 / 100;
    var maxHeight1 = maxHeight*75/100;
    $("#orderNav").css({"width": maxWidth1});
    $("#orderList").css({"width": maxWidth1});
    //触发lookOrder函数
    lookOrder = function(message){
        window.location.href="static/pages/user/order_item.html?orderNo="+message;
    }
    //当页面加载完成后执行
    //查询书籍信息以及关于分页的函数
    $.post("user/selectAllOrders",function (data) {
        if (data != null){
            /*不显示暂无订单*/
            $("#noOrder").css({"display":"none"});
            for (var i in data){
                //订单状态
                var status;
                if (data[i].order_status == 1){
                    status = "未发货";
                }else if (data[i].order_status == 2){
                    status = "已发货";
                }else if (data[i].order_status == 3){
                    status = "已签收";
                }
                $("#orderList").append("<div class='orderItem'>\n" +
                    "        <span class='orderNo'>"+data[i].order_No+"</span>\n" +
                    "        <span class='orderNumber'>"+data[i].order_number+"（件）</span>\n" +
                    "        <span class='orderPrice'>￥"+data[i].order_price+"</span>\n" +
                    "        <span class='orderAddress'>"+data[i].order_address+"</span>\n" +
                    "        <span class='orderStatus'>"+status+"</span>\n" +
                    "        <input type='button' class='orderButton' value='查看订单详情' onclick='lookOrder("+data[i].order_No+")'>\n" +
                    "    </div>");
            }
        }
        if (data == ""){
            $("#noOrder").css({"display":""});
        }
    },"json");
})