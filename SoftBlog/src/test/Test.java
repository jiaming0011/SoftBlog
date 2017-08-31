package test;

import java.util.List;

import bean.Article;
import dao.impl.ArticleDaoImpl;

public class Test {
	public static void main(String[] args) {
		ArticleDaoImpl adi = new ArticleDaoImpl();
		List<Article> list = adi.findPageByBloggerId(1, 1,6);
		for(Article a:list){
			System.out.println(a.getUpdatetime());
		}
		
		
	}

}
