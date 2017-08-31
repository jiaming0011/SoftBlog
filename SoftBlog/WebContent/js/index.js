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

$(document).ready(function(){
	pageIndex=1;
	load(pageIndex);
	$(window).scroll(function(){
	    var scrollTop=$(document).scrollTop(); //滚动条到顶部的垂直高度
	    var windowHeight=$(window).height(); //浏览器窗口的高度
	    var documentHeight=$(document).height();//页面的文档高度
	    if(scrollTop+windowHeight==documentHeight) {
	    	load(pageIndex);
	    }
	});
});

function loadHTML(){
	var html="";
	$.ajax({
		url:"/SoftBlog/page/block.html",
	    dataType:"html",
	    async:false,
	    success: function (data){
	    	html=data;
	    }
	});
	return html;
}

function load(pageIndex){
	$.ajax({
		type:"post",
		url:"/SoftBlog/ArticleAction",
		data:{pageIndex:pageIndex},
		async:true,
		dataType:"json",
		success:show
	});
}

function show(json){
	var html=loadHTML();
	var count=0;
	for(var item in json.Article.list){
		count++;
	}
	if(count==0){
		$(".list-meta").html("你已浏览完所有文章");
	}
	else{
		for(var i=0;i<count;i++)
		{
			$(".list-group").append(html);
			var articleLink="/SoftBlog/page/article.jsp?id="+json.Article.list[i].id;
			$(".title").last().html(json.Article.list[i].title);
			$(".title").last().attr("href",articleLink);
			$(".content").last().html(json.Article.list[i].articlecontent_id.content);
			$(".name").last().html(json.Article.list[i].blogger_id.bloggerinfo_id.name);
			$(".tag").last().html(json.Article.list[i].tag_id.name);
			var time=json.Article.list[i].updatetime.split(" ");
			$(".time").last().html(time[0]);
			$(".reading").last().append(json.Article.list[i].articlestatus_id.reading);
			$(".enjoy").last().append(json.Article.list[i].articlestatus_id.enjoy);
		}
		pageIndex=pageIndex+1;
	}
}
function loadInfo(){
	window.location.href="/SoftBlog/FriendAction";
}




