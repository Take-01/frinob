<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ホーム</title>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<!-- ログイン済なら投稿一覧を表示 -->
	<s:if test='#session.containsKey("loggedIn") && #session.get("loggedIn").equals(1)'>
		<div>
			<s:iterator value="#session.postList">
				<div>
					<a href='<s:url value="PostDetailsAction"><s:param name="postId" value="%{postId}"/></s:url>'></a>
					<img src="postImagePath" alt="">
					<h5><s:property value="postTitle"/></h5>
					<p><s:property value="postBody"/></p>
					<p><s:property value="postUser"/></p>
				</div>
			</s:iterator>
		</div>
	</s:if>

	<!-- 未ログインならサイトの説明、新規登録ボタン、ログインボタンを表示 -->
	<s:else>
		<h1>（サイト名）へようこそ！</h1>
		<p>
			（サイト名）はブログより手軽に、交流できる自由帳、がテーマのサイトです。<br>
			毎日のちょっとしたできごとや、学習用のメモ、レシピの覚書など、ブログは面倒だけどちょっと記録に残したい、というときにおすすめです。<br>
			他のユーザーや投稿をお気に入り登録することもできます。<br>
			シンプルで使いやすいサイトを目指しています。
		</p>
		<div>
			<h4>あなたも参加してみませんか？</h4>
			<a href='<s:url action="CreateUserAction"/>'><button>新規登録</button></a>
		</div>
		<div>
			<h5>もう登録済みですか？</h5>
			<a href='<s:url action="GoLoginAction"/>'><button>ログイン</button></a>
		</div>
	</s:else>
</body>
</html>