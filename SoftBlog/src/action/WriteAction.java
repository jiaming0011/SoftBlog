package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import service.impl.ArticleServiceImpl;
import service.impl.TagServiceImpl;

/**
 * Servlet implementation class WriteAction
 */
@WebServlet("/WriteAction")
public class WriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Write");
		int blogger_id=Integer.parseInt(request.getParameter("Blogger_id"));
		String title= request.getParameter("title");
		String content = request.getParameter("content");
		String tagName=request.getParameter("tag_name");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String updatetime=dateFormat.format(now);
		TagServiceImpl tsi=new TagServiceImpl();
		int tag_id=tsi.getId(tagName);
		ArticleServiceImpl asi=new ArticleServiceImpl();
		PrintWriter out=response.getWriter();
		boolean isFlag=asi.addArticle(content, title, blogger_id, tag_id, updatetime);
        if(isFlag)
        {
        	out.write("true");
        }
        else{
        	out.write("false");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
