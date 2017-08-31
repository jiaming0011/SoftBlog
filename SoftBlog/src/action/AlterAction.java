package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Blogger;
import bean.BloggerInfo;
import dao.impl.BloggerInfoDaoImpl;

/**
 * Servlet implementation class AlterAction
 */
@WebServlet("/AlterAction")
public class AlterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     BloggerInfoDaoImpl bidi = new BloggerInfoDaoImpl();
  
    public AlterAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理AlterAction");
		request.setCharacterEncoding("utf-8");  
	     response.setContentType("text/html;charset=utf-8");
	     HttpSession session = request.getSession();
	     Blogger b = (Blogger)session.getAttribute("Blogger");
         BloggerInfo bi = b.getBloggerinfo_id();
	     String myName= bi.getName();
		 String myBrief=bi.getBrief();
		 myName=request.getParameter("myName")==""?myName:request.getParameter("myName");
		 myBrief=request.getParameter("myBrief")==""?myBrief:request.getParameter("myBrief");
         bi.setName(myName);
         bi.setBrief(myBrief);
         boolean isFlag = bidi.update(bi);
         if(isFlag){
        	  response.sendRedirect("/SoftBlog/FriendAction");  
         }		
         else{
        	 System.out.println("数据库错误");
         }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
