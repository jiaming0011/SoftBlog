package dao;

import bean.LoginInfo;

public interface LoginInfoDao extends BaseDao<LoginInfo> {
	public LoginInfo findLoginInfoByAccount(String account);
}
