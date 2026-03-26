<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, bean.StudentList, dao.StudentListDAO" %>

<%
    StudentListDAO dao = new StudentListDAO();
    List<StudentList> students = dao.showSummary();
%>

<h3>更新したい学生を選択してください。</h3>

<form action="Update_complete" method="post">

    <!-- 学生選択 -->
    <p>
        学生名 :
        <select name="studentId">
            <% for(StudentList s : students) { %>
                <option value="<%= s.getId() %>">
                    <%= s.getName() %>
                </option>
            <% } %>
        </select>
    </p>

    <!-- 新しい名前 -->
    <p>
        新しい名前 :
        <input type="text" name="name">
    </p>

    <!-- コース番号 -->
    <p>
        コース番号 :
        <select name="courseid">
            <option value="1">1</option>
            <option value="2">2</option>
        </select>
    </p>

    <input type="submit" value="更新">

</form>
<a href="menu">メニューへ</a>