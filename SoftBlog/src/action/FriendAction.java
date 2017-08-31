package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Blogger;
import bean.BloggerFavorite;
import dao.impl.BloggerFavoriteDaoImpl;

/**
 * Servlet implementation class FriendAction
 */
@WebServlet("/FriendAction")
public class FriendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     BloggerFavoriteDaoImpl bfdi = new BloggerFavoriteDaoImpl();  
   
    public FriendAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理get请求");
		HttpSession session = request.getSession();
		Blogger b = (Blogger)session.getAttribute("Blogger");
		List<BloggerFavorite> list = bfdi.findBloggerFavoriteById_1(b.getId());
		System.out.println(list.size());
		List<BloggerFavorite> list2 = bfdi.findBloggerFavoriteById_2(b.getId());
		request.setAttribute("BloggerFavorite", list);
		request.setAttribute("BloggerFans", list2);
		request.getRequestDispatcher("/page/BloggerInfo.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
