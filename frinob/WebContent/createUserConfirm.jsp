<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>ユーザー登録確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h3>以下の内容で登録します。</h3>
		<table class="block">
			<s:form method="post">
				<tr>
					<th>ユーザーID</th>
					<td><s:property value="userId"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td>●●●●●●<p>※セキュリティのため非表示</p></td>
				</tr>
				<tr>
					<th>ユーザー名</th>
					<td><s:property value="userName"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="email"/></td>
				</tr>
			</s:form>
		</table>

		<div>
			<a href='<s:url action="CreateUserCompleteAction"/>'><button class="btn">登録完了</button></a>
			<s:form action="CreateUserAction" method="post" class="block">
				<s:submit class="btn" value="戻る" onClick="goCreateUser()"/>
				<s:hidden name="backFlg" id="backFlg"/>
			</s:form>
		</div>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>