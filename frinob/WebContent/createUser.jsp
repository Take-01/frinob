<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>新規ユーザー登録</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<!-- ユーザーID入力チェックメッセージ -->
		<s:if test="userIdMessageList != null && userIdMessageList.size() > 0">
			<s:iterator value="userIdMessageList"><s:property /><br></s:iterator>
		</s:if>
		<!-- パスワード入力チェックメッセージ -->
		<s:if test="passwordMessageList != null && passwordMessageList.size() > 0">
			<s:iterator value="passwordMessageList"><s:property /><br></s:iterator>
		</s:if>
		<!-- ユーザー名入力チェックメッセージ -->
		<s:if test="userNameMessageList != null && userNameMessageList.size() > 0">
			<s:iterator value="userNameMessageList"><s:property /><br></s:iterator>
		</s:if>
		<!-- メールアドレス入力チェックメッセージ -->
		<s:if test="emailMessageList != null && emailMessageList.size() > 0">
			<s:iterator value="emailMessageList"><s:property /><br></s:iterator>
		</s:if>
		<!-- 登録フォーム -->
		<s:form action="CreateUserConfirmAction" method="post">
			<s:textfield name="userId" label="ユーザーID" value='%{#session.userId}'/>
			<s:password name="password" label="パスワード"/>
			<s:textfield name="userName" label="ユーザー名" value='%{#session.userName}'/>
			<s:textfield name="email" label="メールアドレス" value='%{#session.email}'/>
			<s:submit value="新規登録"/>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>