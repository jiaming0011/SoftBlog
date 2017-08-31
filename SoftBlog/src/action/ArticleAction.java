package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ArticlePage;
import dao.impl.ArticleDaoImpl;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ArticleAction
 */
@WebServlet("/ArticleAction")
public class ArticleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ArticleAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loading");
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex")==null?"1":request.getParameter("pageIndex"));
		ArticlePage ap = new ArticlePage();
		ap.setPageIndex(pageIndex);
		ap.setPageSize(6);
		ap.setCountPage(new ArticleDaoImpl().findAllCount());
		ap.initAP();
		ap.setList(new ArticleDaoImpl().findArticleByIndex(ap.getStartIndex(),ap.getPageSize() ));
		System.out.println(ap.getList().size());
		JSONObject json=new JSONObject();
		json.put("Article", ap);
		System.out.println(json);
		response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
