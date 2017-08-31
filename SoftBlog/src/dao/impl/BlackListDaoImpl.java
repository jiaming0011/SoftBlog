package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BlackList;
import dao.BlackListDao;

public class BlackListDaoImpl extends BaseDaoImpl<BlackList>implements BlackListDao {

	@Override
	public List<BlackList> findBlackListByBloggerId(int blogger_id1) {
		List<BlackList> list=new ArrayList<BlackList>();
		String sql="select * from blacklist where blogger_id1=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id1);
		String classname="bean.BlackList";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	

}
