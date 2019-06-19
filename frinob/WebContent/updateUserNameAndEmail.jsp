<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザー名・メールアドレス変更</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<!-- 入力欄 -->
		<s:form action="UpdateUserNameAndEmailConfirmAction" method="post" class="block">
			<p><label>ユーザー名<br><s:textfield name="userName" value="%{userName}"/></label></p>
				<!-- ユーザー名の入力チェックメッセージ -->
				<s:if test="userNameMessageList != null && userNameMessageList.size() > 0">
					<s:iterator value="userNameMessageList"><p class="message"><s:property /></p>></s:iterator>
				</s:if>
			<p><label>メールアドレス<br><s:textfield name="email" value="%{email}"/></label></p>
				<!-- メールアドレスの入力チェックメッセージ -->
				<s:if test="emailMessageList != null && emailMessageList.size() > 0">
					<s:iterator value="emailMessageList"><p class="message"><s:property /></p></s:iterator>
				</s:if>
			<p><s:submit class="btn" value="変更"/></p>
		</s:form>
	</div>
</body>
</html>