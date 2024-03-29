<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿お気に入り登録確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<div class="message">
			<!-- 入力チェックメッセージ -->
			<s:if test="tagMessage != null && tagMessage.length() > 0">
				<s:property value ="tagMessage"/>
			</s:if>
		</div>

		<table class="block">
			<tr>
				<th>タイトル</th>
				<td><s:property value="#session.title"/></td>
			</tr>
			<tr>
				<th>投稿者</th>
				<td><s:property value="#session.writerName"/></td>
			</tr>
			<tr>
				<th>投稿日</th>
				<td><s:property value="#session.registDate"/></td>
			</tr>
			<tr>
				<th>更新日</th>
				<td><s:property value="#session.updateDate"/></td>
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

		<s:form action="RegistFavoritePostCompleteAction" method="post" class="block">
			<p><label>タグ１<br><s:textfield name="tag1"/></label></p>
			<p><label>タグ２<br><s:textfield name="tag2"/></label></p>
			<p><label>タグ３<br><s:textfield name="tag3"/></label></p>
			<p><label>タグ４<br><s:textfield name="tag4"/></label></p>
			<p><label>タグ５<br><s:textfield name="tag5"/></label></p>
			<p><s:submit class="btn" value="完了"/></p>
		</s:form>

		<a href='<s:url action="PostDetailsAction"><s:param name="postId" value="%{#session.postId}"/></s:url>'><button class="btn">戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>