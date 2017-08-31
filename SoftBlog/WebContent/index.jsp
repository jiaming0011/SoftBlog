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

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/SoftBlog/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/SoftBlog/css/index.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="/SoftBlog/js/html5shiv.min.js"></script>
        <script src="/SoftBlog/js/respond.min.js"></script>
        <![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="/SoftBlog/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/SoftBlog/js/jqthumb.min.js"></script>
<script type="text/javascript" src="/SoftBlog/js/index.js"></script>
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

	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		data-pause="null">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide jqthumb" src="img/carousel1.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>有酒有故事，只是在等你。</h1>
						<p>介绍一些最近喜欢听的歌，私以为都还不错。</p>
					</div>
					<div class="carousel-caption" id="carousel-btn">
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">进入专题</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="img/carousel2.jpg" alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>一次心动，一生记忆</h1>
						<p>重要的人，不能忘记的人，不想忘记的人。那些年错过的爱情|经典动画电影</p>
					</div>
					<div class="carousel-caption" id="carousel-btn">
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">进入专题</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="img/carousel3.jpg" alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>One more for good measure.</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
					<div class="carousel-caption" id="carousel-btn">
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">进入专题</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

		<div class="note-list">
				<ul class="list-group">
					
			    </ul>
                <div><p class="list-meta">下拉加载更多</p></div>
		    </div>

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