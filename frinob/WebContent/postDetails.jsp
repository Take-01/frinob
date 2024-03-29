<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿詳細</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<div class="block">
			<h1><s:property value="#session.title"/></h1>
			<h3><a href='<s:url action="UserPostListAction"><s:param name="postDetailsFlg" value="1"/></s:url>'><s:property value="#session.writerName"/></a></h3>
			<p class="category">カテゴリー：<s:property value="#session.categoryName"/></p>
			<p class="date">投稿日：<s:property value="#session.registDate"/>　更新日：<s:property value="#session.updateDate"/></p>
			<div class="text">
				<s:property value="#session.body"/>
			</div>
		</div>

		<s:if test="userFlg == 1"><!-- ユーザーの投稿一覧画面からの遷移だった場合 -->
			<a href='<s:url action="UserPostListAction"><s:param name="postDetailsFlg" value="1"/></s:url>'><button class="btn">戻る</button></a>
		</s:if>
		<s:else>
			<a href='<s:url action="HomeAction"/>'><button class="btn">戻る</button></a>
		</s:else>

		<s:if test="isRegistered">
			<a href='<s:url action="RevokeFavoritePostConfirmAction"/>'><button class="btn">お気に入り解除</button></a>
		</s:if>
		<s:else>
			<a href='<s:url action="RegistFavoritePostConfirmAction"/>'><button class="btn">お気に入り登録</button></a>
		</s:else>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>