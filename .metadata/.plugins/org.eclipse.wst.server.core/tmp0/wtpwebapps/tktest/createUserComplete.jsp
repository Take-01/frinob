<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="refresh" content="3;URL='GoLoginAction'">
	<title>ユーザー登録完了</title>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>ユーザー登録が完了しました。</h1>
		<p>自動でログイン画面へ遷移します。</p>
		<p>ページが変わらない場合は<a href='<s:url action="GoLoginAction"/>'>こちら</a>からログインできます。</p>
	</div>
</body>
</html>