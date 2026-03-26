<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- フォーム：学生の名前を入力して検索 -->
<form action="search_result" method="post">
    お名前：
    <input type="text" name="name"><!-- 名前の入力 -->
    <input type="submit" value="送信"><!-- 送信ボタン -->
</form>

<!-- メニューに戻るリンク -->
<a href="menu">メニューへ</a>