<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザー名・メールアドレス変更確認</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<h1>以下の内容で変更します。</h1>
		<table class="block">
			<tr>
				<th>ユーザー名</th>
				<td><s:property value="#session.userName"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><s:property value="#session.email"/></td>
			</tr>
		</table>

		<form id="updateForm" method="post" class="block">
			<s:hidden name="backFlg" id="backFlg"/>
			<s:submit class="btn" value="戻る" onClick="goUpdateUserNameAndEmailAction()"/>
		</form>

		<a href='<s:url action="UpdateUserNameAndEmailCompleteAction"/>'><button class="btn">完了</button></a>
	</div>
</body>
</html>