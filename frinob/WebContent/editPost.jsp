<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿編集</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<div>
			<!-- タイトル入力チェックメッセージ -->
			<s:if test="titleMessageList != null && titleMessageList.size() > 0">
				<s:iterator value="%{titleMessageList}"><s:property /></s:iterator>
			</s:if>
			<!-- 本文入力チェックメッセージ -->
			<s:if test="bodyMessageList != null && bodyMessageList.size() > 0">
				<s:iterator value="%{bodyMessageList}"><s:property /></s:iterator>
			</s:if>
		</div>

		<!-- 入力フォーム -->
		<s:form method="post" action="EditPostConfirmAction" class="block">
			<s:textfield label="タイトル" name="title" value="%{title}"/>
			<s:textarea label="本文" name="body" value="%{body}"/>
			<s:property value="%{#session.categoryName}"/>
			<s:submit class="btn" value="編集"/>
		</s:form>
	</div>
</body>
</html>