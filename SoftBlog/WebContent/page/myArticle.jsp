<%@ page language="java" import="java.util.*,bean.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
	%>  
<%
	Blogger b = (Blogger)session.getAttribute("Blogger");
	ArticlePage ap = new ArticlePage();
	ap = (ArticlePage)request.getAttribute("ap");
	
%>
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
<link href="/SoftBlog/css/BloggerInfo.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="/SoftBlog/js/html5shiv.min.js"></script>
        <script src="/SoftBlog/js/respond.min.js"></script>
        <![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="/SoftBlog/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/SoftBlog/js/BloggerInfo.js"></script>
<%
	String name="";
    if (session.getAttribute("Blogger") != null) {
%>
<script type="text/javascript">
	verify();
</script>
<%
    Blogger bl=(Blogger) session.getAttribute("Blogger");
    name=bl.getBloggerinfo_id().getName();
	}
%>

</head>

<body >
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
					Blogger bl=(Blogger) session.getAttribute("Blogger");
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
	<div class="row clearfix" id="main-box">
		<div class="col-md-2 column">
			<div class="mar">
			<img alt="未上传头像" src="<%=b.getBloggerinfo_id().getImage() %>" height="130px" width="130px" class="img-circle"  />
			</div>
		</div>
		<div class="col-md-10 column">
		<div class="mar">
			<h2>
				<%=b.getBloggerinfo_id().getName() %>
			</h2>
			<%if(b.getBloggerinfo_id().getBrief()!=null){ %>
			<p>
				<%=b.getBloggerinfo_id().getBrief() %>
			</p>
			<%}else{ %>
			<div class="mar"><h4 style="color:gray">无</h4></div>
			<%} %>
		</div>
		</div>
		<div class="row clearfix">
		<div class="col-md-12 column">
		<% if(ap!=null){ 
			List<Article> list = ap.getList();%>
			<table class="table">
				<thead>
					<tr>
						<th>
							标题
						</th>
						<th>
							提交时间
						</th>
						<th>
							状态
						</th>
						
					</tr>
				</thead>
				<tbody>
					<tr><%if(list.size()>0){ %>
						<td>
							<%=list.get(0).getTitle() %>
						</td>
						<td>
							<%=list.get(0).getUpdatetime() %>
						</td>
						<td>
							<%=list.get(0).getArticlestatus_id().getReading() %>
						</td>
						<%} %>
					</tr>
					<tr class="success"><%if(list.size()>1){ %>
						<td>
							<%=list.get(1).getTitle() %>
						</td>
						<td>
							<%=list.get(1).getUpdatetime() %>
						</td>
						<td>
							<%=list.get(1).getArticlestatus_id().getReading() %>
						</td>
						<%} %>
					</tr>
					<tr class="error">
						<%if(list.size()>2){ %>
						<td>
							<%=list.get(2).getTitle() %>
						</td>
						<td>
							<%=list.get(2).getUpdatetime() %>
						</td>
						<td>
							<%=list.get(2).getArticlestatus_id().getReading() %>
						</td>
						<%} %>
					</tr>
					<tr class="warning">
						<%if(list.size()>3){ %>
						<td>
							<%=list.get(3).getTitle() %>
						</td>
						<td>
							<%=list.get(3).getUpdatetime() %>
						</td>
						<td>
							<%=list.get(3).getArticlestatus_id().getReading() %>
						</td>
						<%} %>
					</tr>
					<tr class="info">
						<%if(list.size()>4){ %>
						<td>
							<%=list.get(4).getTitle() %>
						</td>
						<td>
							<%=list.get(4).getUpdatetime() %>
						</td>
						<td>
							<%=list.get(4).getArticlestatus_id().getReading() %>
						</td>
						<%} %>
					</tr>
				</tbody>
			</table>
			<%} %>
		</div>
	</div>
	</div>
	<center>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="pagination">
				<li>
				<%if(ap.isHasLastPage()){ %>
					 <a href="/SoftBlog/PageAction?bloggerId2=<%=ap.getList().get(0).getBlogger_id().getId()%>&pageIndex=<%=ap.getPageIndex()-1%>">上一页</a>
					 <%} %>
				</li>
				<%if(ap!=null){ %>
					 <%for(int i=1;i<=ap.getCountPage();i++) {%>
					 <li>
					  <a href="/SoftBlog/PageAction?bloggerId2=<%=ap.getList().get(0).getBlogger_id().getId()%>&pageIndex=<%=i%>"><%=i %></a>
					</li>
					<%} %>
				<%} %>
				<li>
					 <%if(ap.isHasNextPage()){ %>
					 <a href="/SoftBlog/PageAction?bloggerId2=<%=ap.getList().get(0).getBlogger_id().getId()%>&pageIndex=<%=ap.getPageIndex()+1%>">下一页</a>
					 <%} %>
				</li>
			</ul>
		</div>
	</div>
	</center>
	
	
	
	
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