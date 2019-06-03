<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="refresh" content="5;URL='IndexAction'">
	<title>セッションタイムアウト</title>
</head>

<body>
	<h1>ログインしていません。</h1>
	<p>自動でインデックス画面へ遷移します。</p>
	<p>ページが変わらない場合は<a href='<s:url action="IndexAction"/>'>こちら</a></p>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>