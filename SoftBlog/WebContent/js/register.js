	var xhr;
	function checkAccount() {
		var reg_account = $("#register-account").val();
		if (reg_account == "") {
			messageShow("1","请输入用户名","#message-box1");
		} 
		else {			
			if (reg_account.length<6||reg_account.length>12) {
				messageShow("0","","#message-box1");
				messageShow("1","请输入长度在6至12位的字符","#message-box1");
			}
			else{
			var URLStr="/SoftBlog/AjaxRegisterAction?method=regAccount&account="+reg_account;
			ajaxRequest("get",URLStr,true,"#message-box1");
			}
		}

	}

	function checkPassword() {
		var reg_pwd =$("#register-password").val();
		var reg_checkPWD =$("#register-password2").val();
		if(reg_pwd==""||reg_pwd.length<6)
		{
			messageShow("1","请输入长度在6以上的密码","#message-box4");
		}
		else{		
	     	if(reg_checkPWD ==""){
		     	messageShow("1","请输入确认密码","#message-box4");
		    }
	     	else{
			     messageShow("0","","#message-box4");
		       	if(!(reg_pwd==reg_checkPWD)){
			 	messageShow("1","确认密码不一致","#message-box4");
			}
		}
		}
	}
	function checkName() {
		var reg_name = $("#register-name").val();
		if(reg_name ==""){
			messageShow("1","请输入昵称","#message-box3");
		}
		else{
			messageShow("0","","#message-box3");
			if(reg_name.length>6){
				messageShow("1","昵称不能超过6位字符","#message-box3");
			}
		}

	}
	function checkEmail() {
		var reg_email = $("#register-email").val();
		var sReg = /[_a-zA-Z\d\-\.]+@[_a-zA-Z\d\-]+(\.[_a-zA-Z\d\-]+)+$/;
			if(reg_email==""){
				messageShow("1","请输入邮箱","#message-box2");
			}
			else{
				messageShow("0","","#message-box2");
				if ( ! sReg.test(reg_email) ){
					messageShow("1","邮箱格式错误","#message-box2");
				}
			}

	}
	/* 显示消息提示      
			type 用于标识消息类型      说明：0 代表清空;1 代表错误;
			meg_context  用于标识消息文本
			meg_box 消息显示的位置
	 */
	
	function messageShow(type,meg_context,meg_box) {
		if(type==0){
			$(meg_box).hide();
        }
		else if(type==1){			
			$(meg_box).show();
			$(meg_box).html(meg_context);
		}
	}
	
			
	/* ajax 异步请求
			ajaxMethod  访问方式    值只能是  get或post,
			ajaxURL   访问地址,
			ajaxSyn	  是否是异步请求  值只能是true/false ,默认值是true.
			meg_box   消息显示的位置
	*/		
	function ajaxRequest(ajaxMethod,ajaxURL,ajaxSyn,meg_box){
		//1.创建xmlHttpRequest 对象  ,创建请求对象
			xhr=new XMLHttpRequest();
			if(xhr!=null){
				//2.设置请求路径和方式
				xhr.open(ajaxMethod, ajaxURL,ajaxSyn);
				//3.设置回调函数
				xhr.onreadystatechange = function(){ajaxCall(meg_box);};
				//4.发送请求
				xhr.send();
				
			}
		
	}
	
	/* 回调函数 */
	function ajaxCall(meg_box) {  
        if(xhr.readyState == 4 ) {       //完全得到服务器的响应  
            if(xhr.status == 200) {      //没有异常  
                var text = xhr.responseText; 
                if(text=="用户名已存在"){
                	messageShow("1",text,meg_box);
                }
                else{
                    messageShow("0",text,meg_box);
                }
            }else if(xhr.status==500){
            	
            }
        }  
    }  
	
	
$(document).ready(function(){
	$("#btn-register").click(function(){
		checkAccount();
		checkEmail();
		checkName();
		checkPassword();	
		if($("#message-box1").css("display")=="none"&&
			$("#message-box2").css("display")=="none"&&
			$("#message-box3").css("display")=="none"&&
			$("#message-box4").css("display")=="none" ){
			$.ajax({
				type:"post",
				url:"/SoftBlog/RegisterAction",
				data:{
					  reg_account:$("#register-account").val(),
					  reg_PWD:$("#register-password").val(),
					  reg_email:$("#register-email").val(),
					  reg_name:$("#register-name").val(),
			          },				
				async:false,
				dataType:"text",
				success:register
			});
		}
		else{
		    $('body,html').animate({ scrollTop: 0 }, 200);
		}
	});
});

function register(args){
	if(args=="true"){
		location.href="/SoftBlog/index.jsp";
	}
}




