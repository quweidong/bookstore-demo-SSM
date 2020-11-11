$(function () {
    var pca = $("#pca");
    var detailAddress = $("#detailAddress");
    $("#confirmAddress").click(function () {
        var flag = window.confirm("确定为以上商品付款吗(不要钱)");
        if (flag == true){
            var address = pca.text()+detailAddress.val()
            $.post("http://10.84.198.103:8080/book_system/OrderServlet","action=payInCar&address="+address,function (data) {
               if (data != null){
                   alert(data);
                   window.location.href = "/book_system/";
               }
            },"text")
        }
    })
})