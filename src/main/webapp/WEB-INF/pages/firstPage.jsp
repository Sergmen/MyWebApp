<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 18.09.19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Отчет</title>
  </head>
  <body>
  <form action="/2" method="POST">
  <input type="submit" value="Получить отчет">
  </form>

  <h2>ОТЧЕТ</h2>
  <table>
    <tr>
      <th>Электроэнергия</th>
      <th>Единицы</th>
      <th>Факт</th>
    </tr>
    <c:forEach var="energy" items="${energyList}">
      <tr>
        <td>${energy.electroenergy}</td>
        <td>${energy.units}</td>
        <td>${energy.fact}</td>
        <td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
