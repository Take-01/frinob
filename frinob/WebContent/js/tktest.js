function goCreateUser() {
	document.getElementById("backFlg").value="1";
}

function goPostCompleteAction() {
	document.getElementById("postForm").action="PostCompleteAction";
}

function goPostAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("postForm").action="PostAction";
}

function goDeletePostConfirmAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("deletePostForm").action="DeletePostConfirmAction";
}

function goDeletePostCompleteAction() {
	document.getElementById("deletePostForm").action="DeletePostCompleteAction";
}

function goPostDetailsAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("postDetailsForm").action="PostDetailsAction";
}

function goRevokeFavoritePostAction() {
	document.getElementById("postDetailsForm").action="RevokeFavoritePostAction";
}

function goRegisterFavoritePostAction() {
	document.getElementById("postDetailsForm").action="RegisterFavoritePostAction";
}

function goMyPageAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("postDetailsForm").action="MyPageAction";
}