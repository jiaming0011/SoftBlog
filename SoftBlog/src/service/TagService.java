package service;

public interface TagService {
	public int getId(String name);
	//通过标签名返回id，若没有则创建再返回id
}
