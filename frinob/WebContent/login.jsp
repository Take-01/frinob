<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<h3>ログインしてください</h3>

		<!-- ユーザーID入力チェックメッセージ -->
		<div class="message">
			<s:if test="userIdMessageList != null && userIdMessageList.size() > 0">
				<s:iterator value="userIdMessageList">
					<s:property/><br>
				</s:iterator>
			</s:if>
		</div>

		<!-- パスワード入力チェックメッセージ -->
		<div class="message">
			<s:if test="passwordMessageList != null && passwordMessageList.size() > 0">
				<s:iterator value="passwordMessageList">
					<s:property/><br>
				</s:iterator>
			</s:if>
		</div>

		<!-- 入力内容が一致しないメッセージ -->
		<div class="message">
			<s:if test="notMatchMessage != null">
				<s:property value="notMatchMessage"/>
			</s:if>
		</div>

		<!-- 入力フォーム -->
		<s:form action="LoginAction" method="post" class="block">
			<s:textfield label="ユーザーID" name="userId" value="%{userId}"/>
			<s:password label="パスワード" name="password"/>
			<s:submit class="btn" value="ログイン"/>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>