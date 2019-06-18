<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>お気に入り投稿一覧</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<!-- お気に入りユーザーがいない -->
		<s:if test="favUserList == null || favUserList.isEmpty()">
			<h1>お気に入りユーザーはいません。</h1>
		</s:if>
		<s:else>
			<h1>お気に入りユーザー一覧</h1>
			<s:iterator value="favUserList">
				<div class="linkBlock block">
					<a class="link" href='<s:url action="UserPostListAction"><s:param name="writerId" value="%{favUserId}"/></s:url>'></a>
					<h3><s:property value="favUserId"/></h3>
					<h3><s:property value="favUserName"/></h3>
				</div>
			</s:iterator>
		</s:else>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>