package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Blogger;
import bean.BloggerInfo;
import dao.impl.BloggerInfoDaoImpl;


@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }
    BloggerInfoDaoImpl bidi = new BloggerInfoDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("处理get请求");
			request.setCharacterEncoding("utf-8");  
		     response.setContentType("text/html;charset=utf-8");
		     //为解析类提供配置信息  
		     DiskFileItemFactory factory = new DiskFileItemFactory(); 
		     //创建解析类的实例  
		     ServletFileUpload sfu = new ServletFileUpload(factory);
		     //开始解析  
		     sfu.setFileSizeMax(1024*400);  
		   //每个表单域中数据会封装到一个对应的FileItem对象上  
		     try{
		    	 List<FileItem> items = sfu.parseRequest(request); 
		    	 //区分表单域  
		    	 for (int i = 0; i < items.size(); i++) {  
		                FileItem item = items.get(i);  
		              //isFormField为true，表示这不是文件上传表单域  
		                if(!item.isFormField()){  
		                    ServletContext sctx = getServletContext();  
		                    //获得存放文件的物理路径  
		                    //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹  
		                    String path = sctx.getRealPath("/img");  
		                    System.out.println(path); 
		                    //获得文件名  
		                    String fileName = item.getName();  
		                    System.out.println(fileName);  
		                  //该方法在某些平台(操作系统),会返回路径+文件名  
		                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
		                    File file = new File(path+"\\"+fileName);  
		                    HttpSession session = request.getSession();
	                        Blogger b = (Blogger)session.getAttribute("Blogger");
	                        BloggerInfo bi = b.getBloggerinfo_id();
	                        String newImage = "/SoftBlog/img/"+fileName;
	                        bi.setImage(newImage);
	                        boolean isFlag = bidi.update(bi);
		                    if(!file.exists()){  
		                        item.write(file);  
		                        System.out.println(fileName);  
		                       if(isFlag){
		                        	  response.sendRedirect("/SoftBlog/FriendAction");  
		                        }
		                    }
		                    else{
		                    	response.sendRedirect("/SoftBlog/FriendAction");  
		                    }
		                }  
		            }  
		        }catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
