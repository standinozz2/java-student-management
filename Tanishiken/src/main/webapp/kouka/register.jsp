<%@page contentType="text/html; charset=UTF-8" %>

<%="追加する学生の情報を入力してください。" %>
<form action="register_complete" method="post" >
<!-- 学生番号の入力 -->
学生番号 : <input type="number" min="1" max="99999999" name="stuid"><br>
<!-- 学生名の入力 -->
学生名   : <input type="text" name="name" ><br>
<!-- コース番号の選択 -->
コース番号 :<select name="courseid">
  <option value="1">1</option>
  <option value="2">2</option>
  
</select>
<input type="submit" name="送信" >

</form>
<!-- メニューへ戻る -->
<a href="menu">メニューへ</a>