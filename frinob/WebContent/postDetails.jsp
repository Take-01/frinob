<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>投稿詳細</title>
	<link rel="stylesheet" type="text/css" href="./css/frinob.css">
	<script type="text/javascript" src="./js/frinob.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div id="main">
		<div>
			<h1><s:property value="#session.title"/></h1>
			<h3><s:property value="#session.writerName"/></h3>
			<p><s:property value="#session.categoryName"/></p>
			<p>投稿日：<s:property value="#session.registDate"/>　更新日：<s:property value="#session.updateDate"/></p>
			<div>
				<s:property value="#session.body"/>
			</div>
		</div>

		<s:form id="postDetailsForm" method="post">
			<s:hidden name="backFlg" id="backFlg"/>
			<s:submit value="戻る" onClick="goHomeAction()"/>
		</s:form>

		<%-- <s:if test="isRegistered">
			<a href='<s:url action="RevokeFavoritePostAction"/>'><button>お気に入り解除</button></a>
		</s:if>
		<s:else>
			<a href='<s:url action="RegistFavoritePostAction"/>'><button>お気に入り登録</button></a>
		</s:else> --%>
	</div>

	<footer>
		<p>&copy; フリノブ</p>
	</footer>
</body>
</html>