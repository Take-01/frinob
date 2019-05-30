<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>投稿詳細</title>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<div id="main">
		<div>
			<h1><s:property value="#session.title"/></h1>
			<h6><s:property value="#session.writerName"/></h6>
			<p><s:property value="#session.categoryName"/></p>
			<p>投稿日：<s:property value="#session.registDate"/>　更新日：<s:property value="#session.updateDate"/></p>
			<div>
				<s:property value="#session.body"/>
			</div>
		</div>
		
		<s:form id="postDetailsForm" method="post">
			<s:hidden name="backFlg" id="backFlg"/>
			<s:submit value="戻る" onClick="goPostDetailsAction()"/>
			<s:if test="isRegistered">
				<s:submit value="お気に入り解除" onClick="goRevokeFavoritePostAction()"/>
			</s:if>
			<s:else>
				<s:submit value="お気に入り登録" onClick="goRegisterFavoritePostAction()"/>
			</s:else>
		</s:form>
	</div>
</body>
</html>