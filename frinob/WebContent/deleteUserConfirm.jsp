<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザー削除確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>以下のユーザーを削除しますか？</h1>
		<h3>ユーザーに紐付く全ての情報は削除され、復元はできません。</h3>
		<table class="block">
			<tr>
				<th>ユーザーID</th>
				<td><s:property value="#session.userId"/></td>
			</tr>
			<tr>
				<th>ユーザー名</th>
				<td><s:property value="#session.userName"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><s:property value="#session.email"/></td>
			</tr>
		</table>

		<h5>削除する場合、パスワードを入力してください。</h5>
		<s:form method="post" action="DeleteUserCompleteAction" class="block">
			<p><label>パスワード</label><br><s:password name="password"/></p>
			<p><s:submit class="btn" value="削除"/></p>
		</s:form>
		<a href='<s:url action="UpdateUserAction"/>'><button class="btn">変更</button></a>
		<a href='<s:url action="MyPageAction"/>'><button class="btn">戻る</button></a>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>