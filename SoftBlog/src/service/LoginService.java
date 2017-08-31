package service;

public interface LoginService {
	public boolean login(String account,String password);
	//登录，传入账户和密码
	public boolean register(String account,String password,String name,String email,String tag[]);
	//注册，account,password添加在logininfo表，name，email使用bloggerinfo，tag使用tagfavorite
}
