package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginInfo;
import dao.impl.LoginInfoDaoImpl;
import service.impl.LoginServiceImpl;

/**
 * Servlet implementation class AjaxRegisterAction
 */
@WebServlet("/AjaxRegisterAction")
public class AjaxRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginInfoDaoImpl lidi = new LoginInfoDaoImpl();
    
    public AjaxRegisterAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnStr="";
		String method=request.getParameter("method")==null?"":request.getParameter("method");
		if(!method.equals("")){
			switch(method){
			case "regAccount":
				returnStr = "用户名可用";
				String account = request.getParameter("account")==null?"":request.getParameter("account");
				List<LoginInfo> list =  lidi.findAll();
				for(LoginInfo l:list){
					if(l.getAccount().equals(account)){
						returnStr = "用户名已存在";
						break;
					}
				}
			}
			
		}
//		System.out.println(returnStr);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();  
	    out.print(returnStr);  
	    out.flush();  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
