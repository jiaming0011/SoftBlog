package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.Blogger;
import bean.Comment;
import dao.CommentDao;
import dao.impl.BloggerDaoImpl;
import dao.impl.CommentDaoImpl;
import dao.impl.LoginInfoDaoImpl;
import service.impl.CommentServiceImpl;

/**
 * Servlet implementation class CommentAction
 */
@WebServlet("/CommentAction")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CommentServiceImpl csi=new CommentServiceImpl();
    LoginInfoDaoImpl ldi = new LoginInfoDaoImpl();
    BloggerDaoImpl bdi = new BloggerDaoImpl();
    static List<String> strSendConentList=new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment co=new Comment();
		Blogger bl=new Blogger();
		Article ar=new Article();
		CommentDaoImpl cdi=new CommentDaoImpl();
		
		csi.addComment(co.getContent(), co.getUpdatetime(), bl.getId(), ar.getId());
		
		request.getParameter("method");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
