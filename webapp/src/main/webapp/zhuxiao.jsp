<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br><br><br>

     <%
      response.setHeader("refresh","3;URL=login.jsp");
      session.invalidate();
     %>
     <center>
     <h3>你已经成功退出本系统,<span id="time">3</span>秒后会跳转到首页</h3>
     <h3>如果没有跳转请点击<a href="login.jsp">这里</a></h3>
     </center>
</body>
<script type="text/javascript">
/*思路分析
 * 通过定时器去改变 span 的innerHTML
 * */
 var time=document.getElementById('time');
 var curTime=3;
 setInterval(function () {
     curTime--;
     time.innerHTML=curTime;
     if(curTime<0){
         window.close();
     }
 },1000);
</script>
</html>