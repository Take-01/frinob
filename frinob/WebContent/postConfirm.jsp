<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>投稿確認</title>
	<script type="text/javascript" src="js/tktest.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<div id="main">
		<h1>以下の内容で投稿します。</h1>
		<table>
			<tr>
				<th>タイトル</th>
				<td><s:property value="#session.title"/></td>
			</tr>
			<tr>
				<th>本文</th>
				<td><s:property value="#session.body"/></td>
			</tr>
			<tr>
				<th>カテゴリー</th>
				<td><s:property value="#session.categoryName"/></td>
			</tr>
		</table>
		
		<s:form id="postForm" method="post">
			<s:submit value="投稿" onClick="goPostCompleteAction()"/>
			<s:hidden name="backFlg" id="backFlg" value=""/>
			<s:submit value="戻る" onClick="goPostAction()"/>
		</s:form>
	</div>
</body>
</html>