function goCreateUser() {
	document.getElementById("backFlg").value="1";
}

function goPostAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("postForm").action="PostAction";
}

function goDeletePostConfirmAction() {
	document.getElementById("backFlg").value="1";
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

function goHomeAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("postDetailsForm").action="HomeAction";
}

function goUpdateUserNameAndEmailAction() {
	document.getElementById("backFlg").value="1";
	document.getElementById("updateForm").action="UpdateUserNameAndEmailAction";
}

function goEditPostAction() {
	document.getElementById("backFlg").value="1";
}