<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-5-15
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath();%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<html>
<head>
    <title>Title</title>
    <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

    <link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="../css/hmstyle.css" rel="stylesheet" type="text/css"/>
    <link href="../css/skin.css" rel="stylesheet" type="text/css" />
    <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>
<body>

<!--顶部导航条 -->
<div class="am-container header">
    <ul class="message-l">
        <div class="topMessage">
            <div class="menu-hd" id="usertologin">
                 <input id="username" type="hidden" value="${user.uname}">
                <script>
                    //alert($('#username').val()) ;
                    var html="";
                    if($('#username').val() != null & $('#username').val() !=""){
                        html="${user.uname}，<a href='zhuxiao.jsp'>退出登录</a>";
                        $('#usertologin').html(html);
                    }else{
                        html="<a href='login.jsp' target='_top' class='h'>亲，请登录</a>" +
                            " <a href='register.jsp' target='_top'>免费注册</a>";
                        $('#usertologin').html(html);
                    }



                </script>


                <%--<a href="login.jsp" target="_top" class="h">亲，请登录</a>
                <a href="register.jsp" target="_top">免费注册</a>--%>


            </div>
        </div>
    </ul>



    <ul class="message-r">
        <div class="topMessage home">
            <div class="menu-hd"><a href="index.jsp" target="_top" class="h">商城首页</a></div>
        </div>
        <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a href="<%=path%>/ncyController/tocenter" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
        </div>
        <div class="topMessage favorite">
            <div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
        </div>
    </ul>
</div>
</body>
</html>
