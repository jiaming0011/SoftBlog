package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.MySqlDBUtil;
import bean.LoginInfo;
import bean.Tag;
import dao.TagDao;

public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao {
	MySqlDBUtil md=new MySqlDBUtil();

	public Tag FindByName(String name) {
		Tag t = new Tag();
		Connection conn = md.getConnection();
		PreparedStatement prestm=null;
		ResultSet rs=null;
		String sql = "select * from Tag where name=?";
		try {
			prestm = conn.prepareStatement(sql);
			prestm.setString(1, name);
			rs = prestm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					t.setId(rs.getInt(1));
					t.setName(rs.getString(2));
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return t ;
		
	}

	
}
