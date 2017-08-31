<%@ page language="java" import="java.util.*,bean.BloggerFavorite,bean.Blogger,bean.BloggerInfo" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
	%>  
<%
	List<BloggerFavorite> list =(List<BloggerFavorite>)request.getAttribute("BloggerFavorite"); 
	List<BloggerFavorite> list2 =(List<BloggerFavorite>)request.getAttribute("BloggerFans"); 
	Blogger b = (Blogger)session.getAttribute("Blogger");
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
			<div class="col-md-12 column">
			 <a id="modal-939028" href="#modal-container-939028" role="button" class="btn btn-default" data-toggle="modal">修改我的头像</a>
			
			<div class="modal fade" id="modal-container-939028" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						</div>
						
						<form action="./UpLoad" method="post" enctype="multipart/form-data">  
    					 请选择上传的图片:<input type="file" name="fileName" /> 
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="submit" class="btn btn-primary">保存</button>
						</div>
						 </form>  
					</div>
					
				</div>
				
			</div>
			
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
		<div class="mar">
		<a id="modal-33120" href="#modal-container-33120" role="button" class="btn btn-default" data-toggle="modal">修改个人信息</a>
			
			<div class="modal fade" id="modal-container-33120" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
					<form action="./AlterAction" method="post">
						<div class="modal-header">
							
								<div class="modal-body">
								<center>
								<div class="mar">	昵称：<input type="text" name="myName"  width="100px"><br></div>
								<div class="mar">	签名：<input type="text" name="myBrief"><br></div>
								</center>
								</div>
						</div>
						<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="submit" class="btn btn-primary">保存</button>
						</div>
					</form>
					</div>
					
				</div>
				
			</div>
		</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column" id="table-box">
			<div class="tabbable" id="tabs-811670">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-387648" data-toggle="tab" >关注</a>
					</li>
					<li>
						 <a href="#panel-151727" data-toggle="tab" >粉丝</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-387648">
					<%if(list.size()>0) {
								for(int i=0;i<list.size();i++){%>
						<div class="row clearfix">
							<div class="col-md-2 column">
							<div class="mar">
							
								<img alt="<%=list.get(i).getBlogger_id2().getBloggerinfo_id().getImage() %>" src="<%=list.get(i).getBlogger_id2().getBloggerinfo_id().getImage() %>" class="img-circle" id = "icon2" height="130px" width="130px" />
							</div>
							</div>
							<div class="col-md-10 column">
							<div class="mar">
								<h2>
								<%=list.get(i).getBlogger_id2().getBloggerinfo_id().getName() %>
								</h2>
								<p>
								<%=list.get(i).getBlogger_id2().getBloggerinfo_id().getBrief() %>
								</p>
								<p>
								 <a class="btn" href="#">查看更多</a>
								</p>
							
							</div>
							</div>
						</div>
								<% }
							} else{ %>
							<div class="mar"><h4 style="color:gray">您还没有关注好友</h4></div>
							<%} %>
					</div>
					<div class="tab-pane" id="panel-151727">
						<%if(list2.size()>0) {
								for(int i=0;i<list2.size();i++){%>
						<div class="row clearfix">
							<div class="col-md-2 column">
							<div class="mar">
							
								<img alt="140x140" src="<%=list2.get(i).getBlogger_id1().getBloggerinfo_id().getImage() %>" class="img-circle" height="130px" width="130px"/>
							</div>
							</div>
							<div class="col-md-10 column">
							<div class="mar">
								<h2>
								<%=list2.get(i).getBlogger_id1().getBloggerinfo_id().getName() %>
								</h2>
								<p>
								<%=list2.get(i).getBlogger_id1().getBloggerinfo_id().getBrief() %>
								</p>
								<p>
								 <a class="btn" href="#">查看更多</a>
								</p>
							
							</div>
							</div>
						</div>
								<% }
							}else{ %>
							<div class="mar"><h4 style="color:gray">您还没有粉丝</h4></div>
							<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
	
	</div>
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