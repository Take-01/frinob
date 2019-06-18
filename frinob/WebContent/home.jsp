<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿一覧</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<s:if test="postList == null || postList.isEmpty()">
			<h1>投稿情報がありません。</h1>
		</s:if>
		<s:else>
			<s:iterator value="postList">
			<div class="linkBlock block">
				<a class="link" href='<s:url value="PostDetailsAction"><s:param name="postId" value="%{id}"/></s:url>'></a>
				<h3><s:property value="title"/></h3>
				<p><s:property value="body"/></p>
				<p><s:property value="writerName"/></p>
			</div>
			</s:iterator>
		</s:else>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>