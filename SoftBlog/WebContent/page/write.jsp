<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Blogger,bean.BloggerInfo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>SoftBlog</title>

		<!-- Bootstrap -->
		<link href="/SoftBlog/css/bootstrap.min.css" rel="stylesheet">
		<link href="/SoftBlog/css/trumbowyg.css" rel="stylesheet">
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<link href="/SoftBlog/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="/SoftBlog/css/write.css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
        <script src="/SoftBlog/js/html5shiv.min.js"></script>
        <script src="/SoftBlog/js/respond.min.js"></script>
        <![endif]-->

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/javascript" src="/SoftBlog/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="/SoftBlog/js/jqthumb.min.js"></script>
		<script type="text/javascript" src="/SoftBlog/js/trumbowyg.min.js"></script>
		<script type="text/javascript" src="/SoftBlog/js/write.js"></script>
<%
    String name="";
	if (session.getAttribute("Blogger") != null) {
%>
		<script type="text/javascript">
			verify();
		</script>
		<%
	    Blogger b=(Blogger) session.getAttribute("Blogger");
	    name=b.getBloggerinfo_id().getName();
	}
	else{
		%>
		<script type="text/javascript">
			noBlogger();
		</script>
		<%
	}
%>
	</head>

	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href=""> SolfBlog </a>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div id="btn-corner" class="navbar-right">
			<a type="button" class="btn btn-default navbar-btn navbar-righ "
				href="/SoftBlog/page/login.html" id="btn-sign">登陆/注册</a> <a type="button"
				class="btn btn-success" href="/SoftBlog/page/write.jsp" id="btn-wirte">写文章</a>
			<div class="btn-group" id="btn-user">
				<button type="button"
					class="btn btn-default dropdown-toggle navbar-btn navbar-right "
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<%=name %> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<%if (session.getAttribute("Blogger") != null) { 
					Blogger b=(Blogger) session.getAttribute("Blogger");
					%>
					<li><a href="/SoftBlog/PageAction?bloggerId2=<%=b.getId()%>">我的文章</a></li>
					<%} %>
					<li><a onclick="loadInfo()">个人信息</a></li>
					<li><a href="/SoftBlog/page/overPwd.jsp">安全设置</a></li>
					
					<li role="separator" class="divider"></li>
					<li><a href="/SoftBlog/LogoutAction">注销</a></li>
				</ul>
			</div>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/SoftBlog/index.jsp">首页</a></li>
				<li><a href="#link1">专题</a></li>
				<li><a href="#link2">发现</a></li>
			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

<div class="container">
	<div class="title-box">
	<div class="title">标题:</div>
	<div class="title-input">
	<input type="text" class="form-control" id="title-textarea" placeholder="Title" onkeyup="checkTitle()">
	</div>
	<div class="alert alert-danger" role="alert" id="message-box1"></div>
	</div>

	<div id="editor">
				
	</div>
		<center>
	<button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" id="btn-tag">
            选择标签
    </button>
	</center>
		
<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">标签</h4>
      </div>
      <div class="modal-body">
       <input type="text" class="form-control" id="tag-textarea" placeholder="Tag" onkeyup="checkTag()">
       <div class="alert alert-danger" role="alert" id="message-box2"></div>
      </div>
      <div class="modal-footer">
      <button class="btn btn-lg btn-primary  " type="button" id="btn-submit">发表</button>
      </div>
    </div>
  </div>
</div>
    <script type="text/javascript">
    $("#btn-submit").click(function (){
	<%
		if (session.getAttribute("Blogger") == null) {
	%>
	     noBlogger();
			<%
		}
		else{
			Blogger b=(Blogger) session.getAttribute("Blogger");
		%>
		    var Blogger_id=<%=String.valueOf(b.getId()) %>
		    submit(Blogger_id);
		<%
		}
	%>
    });
	</script>

</div>
		<!-- /.container -->

		<footer class="footer">
			<div class="container">
				<p class="text-muted" id="footer">@SoftBlog</p>
			</div>
		</footer>

		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="/SoftBlog/js/bootstrap.min.js"></script>
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="/SoftBlog/js/ie10-viewport-bug-workaround.js"></script>
	</body>

</html>