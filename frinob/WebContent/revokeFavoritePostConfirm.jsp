<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>お気に入り投稿解除確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<h1>以下の投稿のお気に入り登録を解除します。</h1>
		<table>
			<tr>
				<th>タイトル</th>
				<td><s:property value="#session.title"/></td>
			</tr>
			<tr>
				<th>投稿者</th>
				<td><s:property value="#session.title"/></td>
			</tr>
			<tr>
				<td>投稿日：<s:property value="#session.registDate"/></td>
				<td>更新日：<s:property value="#session.updateDate"/></td>
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

		<a href='<s:url action="RevokeFavoritePostCompleteAction"/>'><button>完了</button></a>
		<a href='<s:url action="PostDetailsAction"><s:param name="postId" value="%{#session.postId}"/></s:url>'><button>戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>