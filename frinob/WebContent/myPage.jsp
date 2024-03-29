<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>マイページ</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<div class="box-parent">
			<div id="left" class="block">
				<p><a href='<s:url action="UpdateUserInfoAction"/>'>ユーザー情報変更</a></p>
				<p><a href='<s:url action="FavoritePostListAction"/>'>お気に入り投稿一覧</a></p>
				<p><a href='<s:url action="FavoriteUserListAction"/>'>お気に入りユーザー一覧</a></p>
			</div>
			<div id="right">
				<s:if test="postList == null || postList.isEmpty()">
					<h1>投稿情報がありません。</h1>
				</s:if>
				<s:else>
					<s:iterator value="postList">
						<div class="linkBlock block">
							<a class="link"
								href='<s:url value="MyPostDetailsAction"><s:param name="postId" value="%{id}"/></s:url>'></a>
							<h3>
								<s:property value="title" />
							</h3>
							<p class="text">
								<s:property value="body" />
							</p>
							<p class="date">
								投稿日：
								<s:property value="registDate" />
								更新日：
								<s:property value="updateDate" />
							</p>
						</div>
					</s:iterator>
				</s:else>
			</div>
		</div>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>