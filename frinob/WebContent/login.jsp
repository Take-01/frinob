<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>

<body>
	<jsp:include page="header.jsp" />

	<h1>ログイン画面</h1>

	<h3>ログインしてください</h3>

	<!-- 入力チェックメッセージ -->
	<s:if test="userIdMessageList != null && userIdMessageList.size() > 0">
		<s:iterator value="userIdMessageList">
			<s:property /><br>
		</s:iterator>
	</s:if>

	<!-- 入力チェックメッセージ -->
	<s:if
		test="passwordMessageList != null && passwordMessageList.size() > 0">
		<s:iterator value="passwordMessageList">
			<s:property /><br>
		</s:iterator>
	</s:if>

	<!-- 入力フォーム -->
	<s:form action="LoginAction" method="post">
		<s:textfield label="ユーザーID" name="userId" />
		<s:password label="パスワード" name="password" />
		<s:submit value="ログイン" />
	</s:form>
</body>
</html>