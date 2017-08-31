package service.impl;

import service.TagService;
import util.BaseDaoUtil;
import bean.Tag;
import dao.impl.TagDaoImpl;

public class TagServiceImpl implements TagService {
		TagDaoImpl tdi = new TagDaoImpl();
		BaseDaoUtil bdu = new BaseDaoUtil();
	@Override
	public int getId(String name) {
		Tag t = new Tag();
		t = tdi.FindByName(name);
		if(t.getId()!=0){
			return t.getId();
		}
		else{
			t.setName(name);
			tdi.add(t);
			return bdu.getMaxId("Tag");
		}
	}

}
