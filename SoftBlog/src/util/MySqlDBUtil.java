package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlDBUtil {
	private final String url="jdbc:mysql://localhost:3306/SoftBlog?characterEncoding=utf-8";
	private final String account="root";
	private final String password="123456";
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,account,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;		
	}

	public void closeConnection(Connection conn,PreparedStatement prestm,ResultSet rs)
	{
		try {
		    if(rs!=null)
			{
			    rs.close();
			}
			if(prestm!=null)
			{
				prestm.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	

	}
}
