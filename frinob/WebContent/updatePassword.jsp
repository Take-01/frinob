<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>パスワード再設定</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<h1>パスワード再設定</h1>

		<!-- パスワード入力チェックメッセージ -->
		<s:if test="passwordMessageList != null && passwordMessageList.size() > 0">
			<s:iterator value="passwordMessageList"><s:property /></s:iterator>
		</s:if>

		<!-- 新しいパスワード不一致メッセージ -->
		<s:if test="notMatchMessage != null && notMatchMessage.length() > 0">
			<s:property value="notMatchMessage"/>
		</s:if>

		<s:form method="post" action="UpdatePasswordCompleteAction" class="block">
			<s:password name="oldPassword" label="現在のパスワード"/>
			<s:password name="newPassword" label="新しいパスワード"/>
			<s:password name="newPasswordConfirm" label="新しいパスワード(確認用)"/>
			<s:submit class="btn" value="再設定完了"/>
		</s:form>

		<a href='<s:url action="UpdateUserInfoAction"/>'><button class="btn">戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>