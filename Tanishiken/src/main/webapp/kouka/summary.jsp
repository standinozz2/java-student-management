<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<table border="1">
<tr>
    <th>学生番号</th>
    <th>学生名</th>
    <th>コース番号</th>
</tr>

<c:forEach var="stu" items="${list}">
<!-- summary.java から取得してループで全員の情報を表示 -->
    <tr>
        <td>${stu.id}</td>
        <td>${stu.name}</td>
        <td>${stu.courseid}</td>
    </tr>
</c:forEach>

</table>
<a href="menu">メニューへ</a>