<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザーお気に入り解除確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>このユーザーのお気に入り登録を解除します</h1>
		<h3>ユーザーID：<s:property value="#session.writerId"/></h3>
		<h3>ユーザー名：<s:property value="#session.writerName"/></h3>

		<a href='<s:url action="RevokeFavoriteUserCompleteAction"/>'><button>完了</button></a>
		<a href='<s:url action="UserPostListAction"><s:param name="writerId" value="%{#session.writerId}"/></s:url>'><button>戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>