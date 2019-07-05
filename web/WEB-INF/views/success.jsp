<%--
  Created by IntelliJ IDEA.
  User: QuLvT
  Date: 2019/7/4
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Success Page</h4>
    time:${requestScope.time}
    names:${requestScope.names}
    <br>
    request user:${requestScope.user}
    <br>
    session user:${requestScope.user}
</body>
</html>
