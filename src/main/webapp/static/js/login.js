//登录页面的js代码
$(function () {
    //获取用户名框dom对象
    var $username = $(".box:eq(0)");
    //获取密码框dom对象
    var $password = $(".box:eq(1)");
    //获取登录界面显示错误信息的span对象
    var $word = $("#error_word");
    //获取注册按钮的dom对象
    var $login_button = $(".login_button");
    //当用户名框获得焦点时
    $username.focus(function () {
        $word.text("");
    })
    //当用户名框失去焦点时
    $username.blur(function () {
        if ($username.val() === ""){
            $word.text("用户名不能为空！");
        }else {
            $word.text("");
        }
    })
    $password.focus(function () {
        $word.text("");
    })
    //当密码框失去焦点时
    $password.blur(function () {
        if ($password.val() === ""){
            $word.text("密码值不能为空！");
        }else {
            $word.text("");
        }
    })
    //当点击登录按钮时,如果用户名不为空且密码也不为空，可以提交表单
    $login_button.click(function () {
        if ($username.val() !== "" && $password.val() !== ""){
            $login_button.attr("type","submit");
        }
    })
    $(".code_img").click(function () {
        this.src = "CodeServlet?d=" + new Date();
    })
})