<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<table border="1">
    <tr>
        <th>学生番号</th>
        <th>学生名</th>
        <th>コース番号</th>
    </tr>
    <c:forEach var="stu" items="${studentList}">
<!-- Search_result.javaから取得してここで表示 -->
    <tr>
        <td>${stu.id}</td>
        <td>${stu.name}</td>
        <td>${stu.courseid}</td>
    </tr>
</c:forEach>
    
</table>

<a href="menu">メニューへ</a><br>
更新したいところありますか？<a href="Update">更新</a>


