<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
	<h1><a href='<s:url action="HomeAction"/>'>サイト名</a></h1>
	<s:if test='#session.containsKey("loggedIn") && #session.get("loggedIn").equals(1)'>
		<a href='<s:url action="MyPageAction"/>'>マイページ</a>
		<a href='<s:url action="LogoutAction"/>' id="logout">ログアウト</a>
	</s:if>
	<s:else>
		<a href='<s:url action="GoLoginAction"/>'>ログイン</a>
	</s:else>
		<a href='<s:url action="PostAction"/>'>投稿</a>
</header>
