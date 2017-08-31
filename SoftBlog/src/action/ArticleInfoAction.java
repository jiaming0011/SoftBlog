package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.Comment;
import dao.impl.ArticleDaoImpl;
import dao.impl.CommentDaoImpl;

/**
 * Servlet implementation class ArticleInfoAction
 */
@WebServlet("/ArticleInfoAction")
public class ArticleInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleDaoImpl adi = new ArticleDaoImpl();  
    CommentDaoImpl cdi = new CommentDaoImpl();
    public ArticleInfoAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理get请求");
		int article_id=Integer.parseInt(request.getParameter("article_id"));
		Article at =  adi.findById(article_id);
		List<Comment> list = cdi.findCommentByArticleId(article_id);
		request.setAttribute("at", at);
		request.setAttribute("list", list);
		request.getRequestDispatcher("").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
