package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import dao.impl.ArticleDaoImpl;
import net.sf.json.JSONObject;
import service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleContentAction
 */
@WebServlet("/ArticleContentAction")
public class ArticleContentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDaoImpl adi=new ArticleDaoImpl();
	ArticleServiceImpl asi=new ArticleServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleContentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoadingContent");
		int id=Integer.parseInt(request.getParameter("id"));
		asi.addReading(id);
		Article a=adi.findById(id);
		JSONObject json=new JSONObject();
		json.put("Article", a);
		System.out.println(json);
		response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
