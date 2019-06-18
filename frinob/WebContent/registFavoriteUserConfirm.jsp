<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザーお気に入り登録確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>このユーザーをお気に入り登録します</h1>
		<h3>ユーザーID：<s:property value="#session.writerId"/></h3>
		<h3>ユーザー名：<s:property value="#session.writerName"/></h3>

		<s:form action="RegistFavoriteUserCompleteAction" method="post" class="block">
			<s:textfield name="tag1" placeholder="タグ１"/>
			<s:textfield name="tag2" placeholder="タグ２"/>
			<s:textfield name="tag3" placeholder="タグ３"/>
			<s:textfield name="tag4" placeholder="タグ４"/>
			<s:textfield name="tag5" placeholder="タグ５"/>
			<s:submit class="btn" value="完了"/>
		</s:form>

		<a href='<s:url action="UserPostListAction"/>'><button class="btn">戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>