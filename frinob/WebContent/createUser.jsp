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

		<!-- 登録フォーム -->
		<s:form action="CreateUserConfirmAction" method="post" class="block">
			<p><label>ユーザーID<br><s:textfield name="userId" value='%{#session.userId}'/></label></p>
				<!-- ユーザーID入力チェックメッセージ -->
				<s:if test="userIdMessageList != null && userIdMessageList.size() > 0">
					<s:iterator value="userIdMessageList"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><label>パスワード<br><s:password name="password" /></label></p>
				<!-- パスワード入力チェックメッセージ -->
				<s:if test="passwordMessageList != null && passwordMessageList.size() > 0">
					<s:iterator value="passwordMessageList"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><label>ユーザー名<br><s:textfield name="userName" value='%{#session.userName}'/></label></p>
				<!-- ユーザー名入力チェックメッセージ -->
				<s:if test="userNameMessageList != null && userNameMessageList.size() > 0">
					<s:iterator value="userNameMessageList"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><label>メールアドレス<br><s:textfield name="email" value='%{#session.email}'/></label></p>
				<!-- メールアドレス入力チェックメッセージ -->
				<s:if test="emailMessageList != null && emailMessageList.size() > 0">
					<s:iterator value="emailMessageList"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><s:submit class="btn" value="新規登録"/></p>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>