<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MING
  Date: 2018/5/24
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览记录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="../../static/css/showRecords.css" >
</head>
<body>
<div class="container">
    <h1>2018/5/24</h1>
    <table class="table table-striped table-bordered record-table">
        <tbody>
        <h1 id="nowDate"></h1>
        <c:forEach var="l" items="${list}">
            <tr>
                <td title="${l.title}" style="width: 25%"><a href="${l.url}" target="_blank">${l.title}</a></td>
                <td title="${l.note}" style="width: 55%">${l.note}</td>
                <td title="${l.time}" style="width: 20%">${l.time}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation" style="text-align: center">
        <ul class="pagination">
            <li>
                <a href="showRecords?pageNum=${pageNum-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pages}" step="1">
                <li><a href="showRecords?pageNum=${i}">${i}</a></li>
            </c:forEach>
            <li>
                <a href="showRecords?pageNum=${pageNum+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>



</body>
</html>
