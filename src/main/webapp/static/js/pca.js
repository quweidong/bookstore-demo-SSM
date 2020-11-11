window.onload = function () {//页面加载完成
    var province = document.getElementById("province");
    var city = document.getElementById("city");
    var area = document.getElementById("area");
    for (var i = 0; i < provinces.length; i++) {//向省下拉列表填充数据
        var option = document.createElement("option");//创建一个option对象
        option.setAttribute("id", provinces[i].id);//设置option的id属性的值
        option.setAttribute("value", provinces[i].id);//设置option的value属性的值
        option.innerHTML = provinces[i].name;//向option中填充内容
        province.appendChild(option);//将potion添加到省列表中
    }
    province.onchange = function () {//省下拉列表域改变事件
        city.innerHTML = " <option value=\"0\">---请选择---</option>";
        var array = citys[province.value];//获取省对应的市的数组
        for (var i = 0; i < array.length; i++) {//向市下拉列表填充数据
            var option = document.createElement("option");
            option.setAttribute("value", array[i].id);
            option.setAttribute("id", array[i].id);
            option.innerHTML = array[i].name;
            city.appendChild(option);
        }
    }
    city.onchange = function () {//市下拉列表域改变事件
        area.innerHTML = " <option value=\"0\">---请选择---</option>";
        var array = areas[city.value];//获取市对应的县的数组
        for (var i = 0; i < array.length; i++) {//向县下拉列表填充数据
            var option = document.createElement("option");
            option.setAttribute("value", array[i].id);
            option.setAttribute("id", array[i].id);
            option.innerHTML = array[i].name;
            area.appendChild(option);
        }
    }
    area.onchange = function () {//县下拉列表域改变事件
        var data1 = document.getElementById(province.value).innerHTML;//获取省的值
        var data2 = document.getElementById(city.value).innerHTML;//获取市的值
        var data3 = document.getElementById(area.value).innerHTML;//获取县的值
        document.getElementById("pca").innerText = data1 + data2 + data3;//向界面填充结果
    }
}