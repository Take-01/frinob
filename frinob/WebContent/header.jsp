<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
	<h1 class="site-name"><a href='<s:url action="HomeAction"/>'>フリノブ</a></h1>
	<ul>
		<s:if test='#session.containsKey("loggedIn") && #session.get("loggedIn").equals(1)'>
			<li><a href='<s:url action="MyPageAction"/>'><button>マイページ</button></a></li>
			<li><a href='<s:url action="LogoutAction"/>'><button>ログアウト</button></a></li>
		</s:if>
		<s:else>
			<li><a href='<s:url action="GoLoginAction"/>'><button>ログイン</button></a></li>
			<li><a href='<s:url action="CreateUserAction"/>'><button>新規登録</button></a></li>
		</s:else>
		<li><a href='<s:url action="PostAction"/>'><button>投稿</button></a></li>
	</ul>
</header>
