<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザー情報変更</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<h1>登録情報</h1>
		<table>
			<tr>
				<th>ユーザーID</th>
				<td><s:property value="userId"/></td>
			</tr>
			<tr>
				<th>ユーザー名</th>
				<td><s:property value="userName"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><s:property value="email"/></td>
			</tr>
		</table>

		<s:form action="UpdateUserNameAndEmailAction" method="post">
			<s:hidden name="userName" value="%{userName}"/>
			<s:hidden name="email" value="%{email}"/>
			<s:submit value="変更"/>
		</s:form>
		<p>パスワードの変更は<a href='<s:url action="UpdatePasswordAction"/>'>こちら</a>からどうぞ</p>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>