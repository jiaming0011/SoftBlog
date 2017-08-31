package service.impl;

import service.BloggerInformationService;
import bean.BloggerInfo;
import dao.impl.BloggerInfoDaoImpl;

public class BloggerInformationServiceImpl implements BloggerInformationService {
	
	@Override
	public boolean updateBloggerInfo(BloggerInfo bi) {
		String name = bi.getName();
		String brief = bi.getBrief();
		String email = bi.getEmail();
		String image = bi.getImage();
		
		//判断条件到时候根据前端再更改
		if(name!=null&&brief!=null&&email!=null&&image!=null){
			if(name.contains(" ")||email.contains(" ")||image.contains(" ")){
				return false;
			}
			BloggerInfoDaoImpl bii = new BloggerInfoDaoImpl();
			bii.add(bi);
			return true;
		}else{
			return false;
		}
	}
	
}
