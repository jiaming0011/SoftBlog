package service.impl;

import java.util.List;

import service.LoginService;
import util.BaseDaoUtil;
import bean.Blogger;
import bean.BloggerInfo;
import bean.BloggerType;
import bean.LoginInfo;
import bean.Tag;
import bean.TagFavorite;
import dao.impl.BloggerDaoImpl;
import dao.impl.BloggerInfoDaoImpl;
import dao.impl.LoginInfoDaoImpl;
import dao.impl.TagDaoImpl;
import dao.impl.TagFavoriteDaoImpl;

public class LoginServiceImpl implements LoginService {

	
	LoginInfoDaoImpl lf = new LoginInfoDaoImpl();
	BloggerInfoDaoImpl bf = new BloggerInfoDaoImpl();
	TagFavoriteDaoImpl tf = new TagFavoriteDaoImpl();
	BloggerDaoImpl bl = new BloggerDaoImpl();
	TagDaoImpl td = new TagDaoImpl();
	BaseDaoUtil bdu = new BaseDaoUtil();
	@Override
	public boolean login(String account, String password) {
		List<LoginInfo> list = lf.findAll();
		for(LoginInfo l:list){
			if(l.getAccount().equals(account)&&l.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean register(String account, String password, String name,
			String email, String tag[]) {
		boolean isFlag = false;
		LoginInfo l = new LoginInfo();
		l.setAccount(account);
		l.setPassword(password);
		lf.add(l);
		BloggerInfo bi = new BloggerInfo();
		bi.setName(name);	
		bi.setEmail(email);
		bf.add(bi);
		BloggerType by = new BloggerType();
		by.setId(1);
		by.setName("用户");
		Blogger be = new Blogger();
		be.setBloggerinfo_id(bf.findBloggerInfoByEmail(email));
		be.setLogininfo_id(lf.findLoginInfoByAccount(account));
		be.setType_id(by);
		isFlag = bl.add(be);
		be.setId(bdu.getMaxId("Blogger"));
		if(tag!=null){
		TagFavorite t = new TagFavorite();
		List<Tag> tt=td.findAll();
		for(int i=0;i<tag.length;i++){
			for(Tag a:tt){
				if(a.getName().equals(tag[i])){
					t.setTag_id(a);
					t.setBlogger_id(be);
					tf.add(t);
					break;
				}
				}
			}
		}
		
		
		
		
		
		return isFlag;
	}

}
