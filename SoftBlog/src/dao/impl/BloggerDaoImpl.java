package dao.impl;

import java.util.ArrayList;
import java.util.List;

import util.BaseDaoUtil;
import bean.Blogger;
import bean.LoginInfo;
import dao.BloggerDao;

public class BloggerDaoImpl extends BaseDaoImpl<Blogger>implements BloggerDao {
	BaseDaoUtil bdu = new BaseDaoUtil();
	@Override
	public Blogger findBloggerByInfo_id(int id) {
		String sql="select * from blogger where logininfo_id=?";
		List<Object> args=new ArrayList<Object>();
        args.add(id);
        String className = "bean.Blogger";
		Blogger bl=(Blogger) bdu.select(sql, args, className).get(0);
		return bl;
	}

	

}
