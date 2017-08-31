$(document).ready(function(){
	$("#btn-login").click(function(){
		$("#alert-login").hide();
		$.ajax({
			type:"post",
			url:"/SoftBlog/LoginAction",
			data:{name:$("#inputAccount").val(),password:$("#inputPassword").val()},
			async:false,
			dataType:"text",
			success:login
		});
	});
});

function login(args){
	if(args=="true"){
		location.href="/SoftBlog/index.jsp"
	}
	if(args=="false"){
	    $("#alert-login").fadeIn();
    }
}


