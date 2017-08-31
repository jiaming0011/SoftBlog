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

$(document).ready(function (){
	var ContentId=window.location.search.substr(4);
	$.ajax({
	    type:"post",
		url:"/SoftBlog/ArticleContentAction",
		data:{id:ContentId},
		async:true,
		dataType:"json",
		success:show
	});
});

function show(json){
	$(".title").html(json.Article.title);
	$(".name").html(json.Article.blogger_id.bloggerinfo_id.name);
	$(".tag").html(json.Article.tag_id.name);
	var time=json.Article.updatetime.split(":");
	$(".time").html(time[0]+":"+time[1]);
	$(".reading").last().append(json.Article.articlestatus_id.reading);
	$(".enjoy").last().append(json.Article.articlestatus_id.enjoy);
	$(".lead").html(json.Article.articlecontent_id.content);
}

function loadInfo(){
	window.location.href="/SoftBlog/FriendAction";
}



