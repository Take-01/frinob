<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿一覧</title>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<div id="main">
		<s:iterator value="#session.postList">
			<div>
				<a href='<s:url value="PostDetailsAction"><s:param name="postId" value="%{postInfoDTO.postId}"/></s:url>'></a>
				<h5><s:property value="postInfoDTO.title"/></h5>
				<p><s:property value="postInfoDTO.body"/></p>
				<p><s:property value="postInfoDTO.writerId"/></p>
			</div>
		</s:iterator>
	</div>
</body>
</html>