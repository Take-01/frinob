<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>フリノブ</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<h1>フリノブへようこそ！</h1>
		<p class="block">
			フリノブはブログより手軽に、交流できる自由帳、がテーマのサイトです。<br>
			毎日のちょっとしたできごとや、学習用のメモ、レシピの覚書など、ブログは面倒だけどちょっと記録に残したい、というときにおすすめです。<br>
			他のユーザーや投稿をお気に入り登録することもできます。<br>

			※現在制作中です。
		</p>
		<div class="block">
			<h4>あなたも参加してみませんか？</h4>
			<a href='<s:url action="CreateUserAction"/>'><button class="btn">新規登録</button></a>
		</div>
		<div class="block">
			<h5>もう登録済みですか？</h5>
			<a href='<s:url action="GoLoginAction"/>'><button class="btn">ログイン</button></a>
		</div>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>