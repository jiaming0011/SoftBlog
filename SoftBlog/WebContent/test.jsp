<%@ page language="java" import="java.util.*,bean.ArticlePage,bean.Article" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	ArticlePage ap = new ArticlePage();
    	ap = (ArticlePage)request.getAttribute("ap");
    	
    %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
     function init(){
    	 location.href="./ArticleAction?pageIndex=1";
     }
</script>
</head>
<body>
	<input id="pageSizeChange_page" type="button"  value="刷新" onclick="init()"/>
	<a href="./ArticleAction?pageIndex=${ap.pageIndex+1}">下一页</a>
	 	<table>
	 		<tr>
			<td>编号</td>
			<td>标题</td>
			<td>更新时间</td>
			</tr>
		<%if(ap!=null){ 
			List<Article> list = ap.getList();%>
		<% for(int i=0;i<list.size();i++ ){%>
		<tr>
			<td><%=list.get(i).getId() %></td>
			<td><%=list.get(i).getTitle() %></td>
			<td><%=list.get(i).getUpdatetime() %></td>
		</tr>	
		<%	}
			}%>
	 	</table>
	 	
	
</body>
</html>