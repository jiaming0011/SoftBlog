package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BloggerInfo;
import bean.LoginInfo;
import dao.BloggerInfoDao;

public class BloggerInfoDaoImpl extends BaseDaoImpl<BloggerInfo>implements BloggerInfoDao {

	@Override
	public BloggerInfo findBloggerInfoByEmail(String email) {
		String sql="select * from bloggerinfo where email=?";
		List<Object> args=new ArrayList<Object>();
        args.add(email);
        String className = "bean.BloggerInfo";
		BloggerInfo bi=(BloggerInfo) dbu.select(sql, args, className).get(0);
		return bi;
		
	}

	

}
