<%--
  Created by IntelliJ IDEA.
  User: 舒意恒
  Date: 2019/5/22
  Time: 9:57
  挂号收费的信息录入页
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%--拼接路径--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>"/>

<!DOCTYPE html>
<html lang="zh-cn">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>挂号</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>

<body>


<%-- 引入 js --%>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<%-- AJAX --%>
<script type="text/javascript">
    $(document).ready(function () {
        $("#rfs").click(function () {
            $.ajax({
                type: "POST",  // 方法类型
                dataType: "json", // 预期服务器返回的数据类型
                url: "registration_info/add", // url
                data: $('#registrationform').serialize(),
                success: function (result) {
                    console.log(result); // 打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                },
                error: function () {
                    alert("异常");
                }
            });
        });
    });
</script>
</body>
</html>
