//注册用户的jquery代码
$(function () {
    //获取用户名框dom对象
    var $username = $(".box:eq(0)")
    //获取密码框dom对象
    var $password = $(".box:eq(1)");
    //获取确认密码框dom对象
    var $password_confirm = $(".box:eq(2)");
    //获取邮箱框的dom对象
    var $email = $(".box:eq(3)");
    //获取注册界面显示错误信息的span对象
    var $word = $("#error_word");
    //获取注册按钮的dom对象
    var $register_button = $(".register_button");
    //用户名的正则表达式
    var userExp = /^[a-zA-Z0-9_]{4,16}$/;
    //邮箱的正则表达式
    var regExp = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    //当用户名框获得焦点时
    $username.focus(function () {
        $word.text("");
    })
    //当用户名框失去焦点时(jquery中不要事件句柄)
    $username.blur(function () {
        //测试用户名是否符合正则表达式
        var flag = userExp.test($username.val());
        if (!flag){
            $word.text("用户名长度4-16且只能含有字母,数字,下划线");
        }
    })
    //当密码框获得焦点时
    $password.focus(function () {
        $word.text("");
    })
    //当密码框失去焦点时
    $password.blur(function () {
        if ($password.val() === ""){
            $word.text("密码值不能为空！");
        }else {
            if ($password.val() === $password_confirm.val()){
                $word.text("");
            }else {
                $word.text("两次密码不一致！");
            }
        }
    })
    //当确认密码框获得焦点时
    $password_confirm.focus(function () {
        $word.text("");
    })
    //当确认密码框失去焦点时
    $password_confirm.blur(function () {
        if ($password_confirm.val() === ""){
            $word.text("确认密码值不能为空！");
        }else {
            if ($password.val() === $password_confirm.val()){
                $word.text("");
            }else {
                $word.text("两次密码不一致！");
            }
        }
    })
    //当邮箱框获得焦点时
    $email.focus(function () {
        $word.text("");
    })
    //当邮箱框失去焦点时
    $email.blur(function () {
        //测试邮箱框中输入的邮箱是否符合正则表达式
        var flag = regExp.test($email.val());
        if (!flag){
            $word.text("邮箱格式不正确！");
        }
    })
    //当点击注册按钮时,如果用户名不为空，密码和确认密码不为空并且相等，邮箱符合格式，那么则可以提交表单
    $register_button.click(function () {
        //测试用户名是否符合正则表达式
        var userNameFlag = userExp.test($username.val());
        //测试邮箱框中输入的邮箱是否符合正则表达式
        var userEmailFlag = regExp.test($email.val());
        if ($password.val() !== "" && $password_confirm.val() !== "" && $password.val() === $password_confirm.val() && userNameFlag && userEmailFlag){
            $register_button.attr("type","submit");
        }
    })
})