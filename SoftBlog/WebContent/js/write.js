$(function(){
        $('img').jqthumb({
            width          : '100%',
            height         : '100%',
            position       : { y: '50%', x: '50%'},
            zoom           : '1',
            method         : 'auto',
        });
    });

function verify(){
	$(document).ready(function(){
	$("#btn-sign").css("display","none");
	$("#btn-wirte").css("display","inline-table");
	$("#btn-user").css("display","inline-table");
	})
}

function noBlogger(){	
	location.href="/SoftBlog/error.html";
}


$(document).ready(function(){
	$("#editor").trumbowyg();
});



function submit(Blogger_id){
	    checkTag();
		if($("#message-box2").css("display")=="none")
	    {
			$.ajax({
				type:"post",
				url:"/SoftBlog/WriteAction",
				data:{
					  Blogger_id:Blogger_id,
					  title:$("#title-textarea").val(),
					  content:$(".trumbowyg-textarea").val(),
					  tag_name:$("#tag-textarea").val()
			          },				
				async:false,
				dataType:"text",
				success:write
			});    
		}
}

function write(args){
	if(args=="true"){
		location.href="/SoftBlog/index.jsp";
	}
}


$(document).ready(function(){
	$("#btn-tag").click(function (){
		checkTitle();
		if($("#message-box1").css("display")=="none")
		{
		    $("#myModal").modal("show");
		}
		else{
		    $('body,html').animate({ scrollTop: 0 }, 200);
		}
	});
});


function checkTitle() {
	var title = $("#title-textarea").val();
	if(title ==""){
		messageShow("1","标题不能为空","#message-box1");
	}
	else{
		messageShow("0","","#message-box1");
	}
}

function checkTag(){
	messageShow("0","","#message-box2");
	var tag = $("#tag-textarea").val();
	if(tag==""){
		messageShow("1","标签不能为空","#message-box2");
	}
	else{
		messageShow("0","","#message-box2");
    }
}

function messageShow(type,meg_context,meg_box) {
	if(type==0){
		$(meg_box).fadeOut();
    }
	else if(type==1){			
		$(meg_box).fadeIn();
		$(meg_box).html(meg_context);
	}
}

function loadInfo(){
	window.location.href="/SoftBlog/FriendAction";
}
