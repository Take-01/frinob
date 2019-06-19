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
		<!-- 入力フォーム -->
		<s:form method="post" action="EditPostConfirmAction" class="block">
			<p><label>タイトル<br><s:textfield name="title" value="%{title}"/></label></p>
				<!-- タイトル入力チェックメッセージ -->
				<s:if test="titleMessageList != null && titleMessageList.size() > 0">
					<s:iterator value="%{titleMessageList}"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><label>本文<br><s:textarea name="body" value="%{body}"/></label></p>
				<!-- 本文入力チェックメッセージ -->
				<s:if test="bodyMessageList != null && bodyMessageList.size() > 0">
					<s:iterator value="%{bodyMessageList}"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p>カテゴリー：<s:property value="%{#session.categoryName}"/></p>
			<p><s:submit class="btn" value="編集"/></p>
		</s:form>
	</div>
</body>
</html>