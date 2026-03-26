<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, bean.StudentList, dao.StudentListDAO" %>

<%
    //StudentListDao を生成
    StudentListDAO dao = new StudentListDAO();
    
    //学生の情報を1件ずつ取得
    List<StudentList> students = dao.showSummary();
%>

<h3>削除したい学生の名前を選択してください。</h3>

<form action="delete_complete" method="post">
    <select name="studentId">
    <% for(StudentList s : students) { %>
        <option value="<%= s.getId() %>">
            <%= s.getName() %>
        </option>
    <% } %>
</select>
    <input type="submit" value="削除">
</form>
<a href="menu">メニューへ</a>