package dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import util.BaseDaoUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	BaseDaoUtil dbu=new BaseDaoUtil();
	private Class<T> c;
	
	public BaseDaoImpl()
	{
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();      
        c = (Class<T>) type.getActualTypeArguments()[0]; 
        System.out.println(1);
        System.out.println(type);
	}
	
	@Override
	public T findById(int id) {
		String sql="select * from "+c.getSimpleName()+" where id=?";
		List<Object> args=new ArrayList<Object>();
        args.add(id);
		T t=(T) dbu.select(sql, args, c.getName()).get(0);
		return t;
	}

	@Override
	public List<T> findAll() {
		String sql="select * from "+c.getSimpleName();
		List<Object> args=new ArrayList<Object>();
		List<T> list=new ArrayList<T>();
		list=dbu.select(sql, args, c.getName());
		return list;
	}

	@Override
	public boolean add(T t) {
		boolean isFlag=false;
		List<Object> args=new ArrayList<Object>();
		Field f[]=c.getDeclaredFields();
		String valueName="";
    	String value="";
		try {
			for(Field tempf:f)
	        {
				tempf.setAccessible(true);
	        	if(tempf.get(t)!=null)
                {
	        		if(tempf.getName().equals("id"))
	        		{
	        			continue;
	        		}
	        		else
	        		{
		        		if(tempf.getName().indexOf("_")>=0)
		        		{
		        			Field fkId=tempf.get(t).getClass().getDeclaredField("id");
		        			fkId.setAccessible(true);
		        			Object obj=fkId.get(tempf.get(t));
		        			args.add(obj);
				        	valueName=valueName+tempf.getName()+",";
				        	value=value+"?,";
		        		}
		        		else
		        		{
		        		Object obj=tempf.get(t);
			        	args.add(obj);
			        	valueName=valueName+tempf.getName()+",";
			        	value=value+"?,";
		        		}
	        		}
	        	}	        	
	        }
			if(!value.equals(""))
			{
				value=value.substring(0, value.length()-1);
				valueName=valueName.substring(0, valueName.length()-1);
			}
			String sql="insert into "+c.getSimpleName()+" ("+valueName+") values("+value+")";
			isFlag=dbu.update(sql, args);
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFlag;
	}

	@Override
	public boolean update(T t) {
		boolean isFlag=false;
		List<Object> args=new ArrayList<Object>();
		Field f[]=c.getDeclaredFields();
		String column="";				
		try {
			for(Field tempf:f)
	        {
				tempf.setAccessible(true);
	        	if(tempf.get(t)!=null)
                {
	        		if(tempf.getName().indexOf("_")>=0)
	        		{
	        			Field fkId=tempf.get(t).getClass().getDeclaredField("id");
	        			fkId.setAccessible(true);
	        			Object obj=fkId.get(tempf.get(t));
	        			args.add(obj);
			        	column=column+tempf.getName()+"=?,";
	        		}
	        		else
	        		{
		        		Object obj=tempf.get(t);
			        	args.add(obj);
			        	column=column+tempf.getName()+"=?,";
	        		}
	        	}
	        }
			if(!column.equals(""))
			{
				column=column.substring(0, column.length()-1);
	        	f[0].setAccessible(true);
	        	if(f[0].get(t)!=null)
	        	{
					args.add(f[0].get(t));
					String sql="update "+c.getSimpleName()+" set "+column+" where id=?";
					isFlag=dbu.update(sql, args);
	        	}
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFlag;
	}

	@Override
	public boolean deleteById(int id) {
		boolean isFlag=false;
		String sql="delete from "+c.getSimpleName()+" where id=?";
		List<Object> args=new ArrayList<Object>();
        args.add(id);
        isFlag=dbu.update(sql, args);
		return isFlag;
	}

}
