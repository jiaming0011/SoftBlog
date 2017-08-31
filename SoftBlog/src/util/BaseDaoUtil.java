package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoUtil {
	
	//通用接口
    
	MySqlDBUtil dbu=new MySqlDBUtil();
	
	public <T> List<T> select(String sql,List<Object> args,String className)
	{
		List<T> list=new ArrayList<T>();
		Connection conn=dbu.getConnection();
		PreparedStatement prestm=null;
		ResultSet rs=null;
		try {
			Class<T> c=(Class<T>) Class.forName(className);
            if(conn!=null)
            {
            	prestm=conn.prepareStatement(sql);
            	if(args.size()>0)
            	{
                	for (int i=0;i<args.size();i++)
                	{
                		prestm.setObject(i+1, args.get(i));
                	}
            	}
            	rs=prestm.executeQuery();          	
				Field f[]=c.getDeclaredFields();
				while(rs.next())
            	{
            		T t=c.newInstance();
            		for(Field tempf:f)
            		{
            			if(tempf.getName().indexOf("_")>=0)
            			{
                		    List<Object> lo=new ArrayList<Object>();
                		    System.out.println("---------------"+tempf.getType().getName());
                		    String tableName=tempf.getType().getName().substring(tempf.getType().getName().lastIndexOf(".")+1);
                		    int id=rs.getInt(tempf.getName());
                		    lo.add(id); 	
                		    String tempSql="select * from "+tableName+" where id=?"; 		   
                		    tempf.setAccessible(true);
                			tempf.set(t, select(tempSql, lo, tempf.getType().getName()).get(0));             			
            			}
            			else
            			{
                		    tempf.setAccessible(true);
                		    Object obj=rs.getObject(tempf.getName());
                		    if(obj!=null)
                		    {
	                		    if(obj.getClass().getSimpleName().equals("Timestamp"))
	                		    {               	
	                		    	String time=obj.toString();
	                		    	tempf.set(t,time);
	                		    }	
	                		    else
	                		    {
	                		        tempf.set(t, obj);
	                		    }
                		    }
            			}
            		}
            		list.add(t);
            	}
				
            }
		} catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			dbu.closeConnection(conn, prestm, rs);
		}
		return list;
		
	}
	
	public boolean update(String sql,List<Object> args)
	{
		boolean isFlag=false;
		Connection conn=dbu.getConnection();
		PreparedStatement prestm=null;
		ResultSet rs=null;
		if(conn!=null)
		{
        	try {
				prestm=conn.prepareStatement(sql);
            	if(args.size()>0)
            	{
                	for (int i=0;i<args.size();i++)
                	{
                		prestm.setObject(i+1, args.get(i));
                	}
            	}
            	int num=prestm.executeUpdate();
            	if(num>0)
            	{
            		isFlag=true;
            	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	finally{
        		dbu.closeConnection(conn, prestm, rs);
        	}
		}
		return isFlag;
		
	}
	public int getMaxId(String tableName) {
		int id1=0;
		Connection conn = dbu.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		if(conn!=null){
			try{	
				String sql = "select max(id) from "+tableName;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()){
					id1=rs.getInt(1);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				dbu.closeConnection(conn, pstmt, rs);
			}
		}
		
		return id1;
	}
	
}
