<%--
  Created by IntelliJ IDEA.
  User: QuLvT
  Date: 2019/7/4
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello world</title>
  </head>
  <body>

    <a href="/springmvc/testRequestMapping">Test RequestMapping</a>
    <br>
    <br>
    <a href="helloworld">Hello world</a>
    <br>
    <br>
    <form action="/springmvc/testMethod" method="post">
      <input type="submit" value="submit">
    </form>
    <br>
    <br>
    <a href="/springmvc/testParamsAndHeaders?username=quzhidiao&age=11">test ParamsAndHeaders</a>
    <br>
    <br>
    <a href="/springmvc/testPathVariable/1">test PathVariable</a>
    <br>
    <br>
    <a href="/springmvc/testRequestParam?username=quzhidiao&age=11">test RequestParam</a>
    <br>
    <br>
    <a href="/springmvc/testCookieValue">test CookieValue</a>
    <br>
    <br>
    <form action="/springmvc/testPojo" method="post">
      username:<input type="text" name="username">
      <br>
      password:<input type="password" name="password">
      <br>
      email:<input type="text" name="email">
      <br>
      age:<input type="text" name="age">
      <br>
      province:<input type="text" name="address.province">
      <br>
      city:<input type="text" name="address.city">
      <br>
      <input type="submit" value="submit">
    </form>
    <br>
    <br>
    <a href="/springmvc/testServletAPI">test ServletAPI</a>
    <br>
    <br>
    <a href="/springmvc/testModelAndView">test ModelAndView</a>
    <br>
    <br>
    <a href="/springmvc/testMap">test Map</a>
    <br>
    <br>
    <a href="/springmvc/testSessionAttribute">test SessionAttribute</a>

    <!--模拟修改操作
    1.原始数据：1，tom，123456，tom@lzu.edu.cn，12
    2.密码不能修改
    3.表单回显，模拟操作直接在表单填写属性值
    -->
    <br>
    <br>
    <form action="/springmvc/testModelAttribute" method="post">
      <input type="hidden" name="id" value="1">
      username:<input type="text" name="username" value="tom">
      <br>
      password:<input type="password" name="password" value="123456">
      <<br>
      email:<input type="text" name="email" value="tom.lzu.edu.cn">
      <br>
      age:<input type="text" name="age" value="12">
      <br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
