package dao.impl;

import java.util.ArrayList;
import java.util.List;

import util.BaseDaoUtil;
import bean.LoginInfo;
import dao.LoginInfoDao;

public class LoginInfoDaoImpl extends BaseDaoImpl<LoginInfo> implements LoginInfoDao {

	BaseDaoUtil bdu = new BaseDaoUtil();
	@Override
	public LoginInfo findLoginInfoByAccount(String account) {
		String sql="select * from logininfo where account=?";
		List<Object> args=new ArrayList<Object>();
        args.add(account);
        String className = "bean.LoginInfo";
		LoginInfo li=(LoginInfo) dbu.select(sql, args, className).get(0);
		return li;
		
	}

	

}
