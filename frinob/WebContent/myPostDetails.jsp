<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿詳細</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<div class="block">
			<h1><s:property value="#session.title"/></h1>
			<p class="category">カテゴリー：<s:property value="#session.categoryName"/></p>
			<p class="date">投稿日：<s:property value="#session.registDate"/>　更新日：<s:property value="#session.updateDate"/></p>
			<div class="text">
				<s:property value="#session.body"/>
			</div>
		</div>

		<a href='<s:url action="MyPageAction"/>'><button class="btn">戻る</button></a>

		<a href='<s:url action="EditPostAction"/>'><button class="btn">編集</button></a>
		<a href='<s:url action="DeletePostConfirmAction"/>'><button class="btn">削除</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>