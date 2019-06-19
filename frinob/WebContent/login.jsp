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

		<!-- 入力内容が一致しないメッセージ -->
		<div class="message">
			<s:if test="notMatchMessage != null">
				<s:property value="notMatchMessage"/>
			</s:if>
		</div>

		<!-- 入力フォーム -->
		<s:form action="LoginAction" method="post" class="block">
			<p><label>ユーザーID<br><s:textfield name="userId" value="%{userId}"/></label></p>
				<!-- ユーザーID入力チェックメッセージ -->
				<s:if test="userIdMessageList != null && userIdMessageList.size() > 0">
					<s:iterator value="userIdMessageList">
						<p class="message"><s:property /></p>
					</s:iterator>
				</s:if>
			<p><label>パスワード<br><s:password name="password"/></label></p>
				<!-- パスワード入力チェックメッセージ -->
				<s:if test="passwordMessageList != null && passwordMessageList.size() > 0">
					<s:iterator value="passwordMessageList">
						<p class="message"><s:property/></p>
					</s:iterator>
				</s:if>
			<p><s:submit class="btn" value="ログイン"/></p>
		</s:form>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>