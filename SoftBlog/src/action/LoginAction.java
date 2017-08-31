package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.LoginServiceImpl;
import bean.Blogger;
import bean.LoginInfo;
import dao.impl.BloggerDaoImpl;
import dao.impl.LoginInfoDaoImpl;

/**
 * Servlet implementation class AccountAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginServiceImpl lsi = new LoginServiceImpl();
    LoginInfoDaoImpl ldi = new LoginInfoDaoImpl();
    BloggerDaoImpl bdi = new BloggerDaoImpl();
    
   
    public LoginAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理请求");
		String account=request.getParameter("name");
		String pwd=request.getParameter("password");
//		response.setContentType("application/text; charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println(account);
		boolean isFlag = lsi.login(account, pwd);
		if(isFlag){		
			Blogger bl = bdi.findBloggerByInfo_id(ldi.findLoginInfoByAccount(account).getId());
			System.out.println(bl.getBloggerinfo_id().getName());
			HttpSession session = request.getSession();
			session.setAttribute("Blogger", bl);
			out.write("true");
		}
		else{
			out.write("false");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
