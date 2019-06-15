<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="refresh" content="2;URL='UserPostListAction'">
	<title>ユーザーお気に入り登録完了</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>登録が完了しました。</h1>
		<p>自動でユーザーの投稿一覧画面へ遷移します。</p>
		<p>ページが変わらない場合は<a href='<s:url action="UserPostListAction"/>'>こちら</a></p>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>