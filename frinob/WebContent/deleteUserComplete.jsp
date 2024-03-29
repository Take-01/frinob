<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<meta http-equiv="refresh" content="2;URL='HomeAction'">
	<title>ユーザー削除完了</title>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>ユーザーを削除しました。</h1>
		<h3>自動でホーム画面へ遷移します。</h3>
		<p>遷移しない場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>