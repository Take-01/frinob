<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>新規投稿</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<!-- 投稿フォーム -->
		<s:form action="PostConfirmAction" method="post" class="block">
			<p><label>タイトル<br><s:textfield name="title" placeholder="タイトル" value="%{#session.title}"/></label></p>
				<!-- タイトル入力チェックメッセージ -->
				<s:if test="titleMessageList != null && titleMessageList.size() > 0">
					<s:iterator value="titleMessageList"><p class="message"><s:property /></p>></s:iterator>
				</s:if>
			<p><label>本文<br><s:textarea name="body" placeholder="本文" value="%{#session.body}"/></label></p>
				<!-- 本文入力チェックメッセージ -->
				<s:if test="bodyMessageList != null && bodyMessageList.size() > 0">
					<s:iterator value="bodyMessageList"><p class="message"><s:property /></p>></s:iterator>
				</s:if>
			<p><label>カテゴリー<br><s:select name="categoryId" list="%{#session.categoryList}" listKey="%{categoryId}" listValue="%{categoryName}" value="%{#session.categoryId}"/></label></p>
			<p><s:submit class="btn" value="投稿"/></p>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>