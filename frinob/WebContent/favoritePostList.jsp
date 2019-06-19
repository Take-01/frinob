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
		<!-- お気に入り投稿がない -->
		<s:if test="favPostList == null || favPostList.isEmpty()">
			<h1>お気に入り投稿がありません。</h1>
		</s:if>
		<s:else>
			<h1>お気に入り投稿一覧</h1>
			<s:iterator value="favPostList">
				<div class="linkBlock block">
					<a class="link" href='<s:url action="PostDetailsAction"><s:param name="postId" value="%{favPostId}"/></s:url>'></a>
					<h3><s:property value="title"/></h3>
					<p><s:property value="writerName"/></p>
					<p class="text"><s:property value="body"/></p>
					<p class="tag">
						<s:property value="postTag1"/>　<s:property value="postTag2"/>　<s:property value="postTag3"/>　<s:property value="postTag4"/>　<s:property value="postTag5"/>
					</p>
				</div>
			</s:iterator>
		</s:else>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>