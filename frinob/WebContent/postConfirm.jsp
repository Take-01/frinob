<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>以下の内容で投稿します。</h1>
		<table class="block">
			<tr>
				<th>タイトル</th>
				<td><s:property value="#session.title"/></td>
			</tr>
			<tr>
				<th>本文</th>
				<td><s:property value="#session.body"/></td>
			</tr>
			<tr>
				<th>カテゴリー</th>
				<td><s:property value="#session.categoryName"/></td>
			</tr>
		</table>

		<a href='<s:url action="PostCompleteAction"/>'><button class="btn">完了</button></a>
		<s:form id="postForm" method="post" class="block">
			<s:hidden name="backFlg" id="backFlg"/>
			<s:submit class="btn" value="戻る" onClick="goPostAction()"/>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>