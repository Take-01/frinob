<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿編集確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>以下の内容で投稿します。</h1>
		<table>
			<tr>
				<th>タイトル</th>
				<td><s:property value="#session.newTitle"/></td>
			</tr>
			<tr>
				<th>本文</th>
				<td><s:property value="#session.newBody"/></td>
			</tr>
			<s:property value="#session.categoryName"/>
		</table>

		<a href='<s:url action="EditPostCompleteAction"/>'><button>完了</button></a>
		<s:form action="EditPostAction">
			<s:hidden name="backFlg" id="backFlg"/>
			<s:submit value="戻る" onClick="goEditPostAction()"/>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>