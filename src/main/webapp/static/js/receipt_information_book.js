$(function () {
    var pca = $("#pca");
    var detailAddress = $("#detailAddress");
    /*获取当前地址栏的链接值*/
    var windowLocalStorage = window.location.href;
    /*截取地址栏字符串，将id后面的值截取出来*/
    var orderNumber = windowLocalStorage.split("?")[1].split("&")[0].split("=")[1];
    var bookId = windowLocalStorage.split("?")[1].split("&")[1].split("=")[1];
    $("#confirmAddress").click(function () {
        var flag = window.confirm("确定为以上商品付款吗(不要钱)");
        if (flag == true){
            var address = pca.text()+detailAddress.val()
            $.post("user/payInBookInformation","orderNumber="+orderNumber+"&orderAddress="+address+"&bookId="+bookId,function (data) {
                if (data != null){
                    alert(data);
                    window.location.href = "/bookstore/";
                }
            },"text")
        }
    })
    $("#returnCar").attr("href","static/pages/book_information.html?bookId="+bookId);
})