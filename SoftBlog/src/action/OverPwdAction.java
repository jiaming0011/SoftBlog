package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Blogger;
import bean.BloggerInfo;
import bean.LoginInfo;
import dao.impl.BloggerInfoDaoImpl;
import dao.impl.LoginInfoDaoImpl;

/**
 * Servlet implementation class OverPwdAction
 */
@WebServlet("/OverPwdAction")
public class OverPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OverPwdAction() {
        super();
        
    }
    BloggerInfoDaoImpl bidi = new BloggerInfoDaoImpl();
    LoginInfoDaoImpl lidi = new LoginInfoDaoImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理OverPwd问题");
		HttpSession session = request.getSession();
		Blogger bl = (Blogger)session.getAttribute("Blogger");
		LoginInfo li=bl.getLogininfo_id();
		BloggerInfo bi=bl.getBloggerinfo_id();
		if(!request.getParameter("reg_PWD").equals("")){
			li.setPassword(request.getParameter("reg_PWD"));
		}
		if(!request.getParameter("reg_email").equals("")){
			bi.setEmail(request.getParameter("reg_email"));
		}
		bidi.update(bi);
		lidi.update(li);
		PrintWriter out=response.getWriter();
		out.write("true");
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
