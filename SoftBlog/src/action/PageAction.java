package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDaoImpl;
import bean.ArticlePage;

/**
 * Servlet implementation class PageAction
 */
@WebServlet("/PageAction")
public class PageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理PageAction");
		int bloggerId = Integer.parseInt(request.getParameter("bloggerId2"));
		System.out.println(bloggerId);
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex")==null?"1":request.getParameter("pageIndex"));
		ArticlePage ap=new ArticlePage();
		ap.setPageIndex(pageIndex);
		ap.setPageSize(5);
		ap.setCountSize(new ArticleDaoImpl().findCountByBlogger_id( bloggerId ));
		ap.initAP();
		ap.setList(new ArticleDaoImpl().findPageByBloggerId( bloggerId , ap.getStartIndex(),ap.getPageSize()));
		request.setAttribute("ap", ap);
		
		request.getRequestDispatcher("page/myArticle.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
