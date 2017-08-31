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
import util.BaseDaoUtil;
import dao.impl.BloggerDaoImpl;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginServiceImpl lsi = new LoginServiceImpl();
    BaseDaoUtil bdu = new BaseDaoUtil();
    BloggerDaoImpl bdi = new BloggerDaoImpl();
   
    public RegisterAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String reg_account = request.getParameter("reg_account");
		String reg_PWD = request.getParameter("reg_PWD");
		String reg_name = request.getParameter("reg_name");
		System.out.println(reg_name);
		String reg_email = request.getParameter("reg_email");
//		String []str2 = request.getParameterValues("tag");
		String []tag = null;
		
		PrintWriter out=response.getWriter();
		
		System.out.println(reg_name);
		boolean isFlag = lsi.register(reg_account, reg_PWD, reg_name, reg_email, tag);
		if(isFlag){
			HttpSession session = request.getSession();
			session.setAttribute("Blogger", bdi.findById(bdu.getMaxId("blogger")));
			//把注册的Blogger对象存进去
			out.write("true");
		}
		else{
			System.out.println("数据库问题");
		}
	}


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
