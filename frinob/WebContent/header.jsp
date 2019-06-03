<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
	<h1><a href='<s:url action="HomeAction"/>'>フリノブ</a></h1>
	<s:if test='#session.containsKey("loggedIn") && #session.get("loggedIn").equals(1)'>
		<a href='<s:url action="MyPageAction"/>'><button>マイページ</button></a>
		<a href='<s:url action="LogoutAction"/>'><button>ログアウト</button></a>
	</s:if>
	<s:else>
		<a href='<s:url action="GoLoginAction"/>'><button>ログイン</button></a>
		<a href='<s:url action="CreateUserAction"/>'><button>新規登録</button></a>
	</s:else>
		<a href='<s:url action="PostAction"/>'><button>投稿</button></a>
</header>
