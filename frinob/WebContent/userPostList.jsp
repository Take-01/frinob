<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザー投稿一覧</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<s:if test="userPostList == null || userPostList.isEmpty()">
			<h1>投稿情報がありません。</h1>
		</s:if>
		<s:else>
			<div id="left">
				<s:property value="#session.writerName"/>
				<s:if test="isRegistered">
					<a href='<s:url action="RevokeFavoriteUserConfirmAction"/>'><button>お気に入り解除</button></a>
				</s:if>
				<s:else>
					<a href='<s:url action="RegistFavoriteUserConfirmAction"/>'><button>お気に入り登録</button></a>
				</s:else>
			</div>
			<div id="right">
				<s:iterator value="userPostList">
					<div class="linkBlock">
						<a class="link" href='<s:url value="PostDetailsAction"><s:param name="postId" value="%{id}"/><s:param name="userFlg" value="1"/></s:url>'></a>
						<h3><s:property value="title"/></h3>
						<p><s:property value="body"/></p>
					</div>
				</s:iterator>
			</div>
		</s:else>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>