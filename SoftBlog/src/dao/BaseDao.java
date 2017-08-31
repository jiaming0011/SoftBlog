package dao;

import java.util.List;

public interface BaseDao<T> {
	
	//通用dao接口
    public T findById(int id);
    
    public List<T> findAll();
    
    public boolean add(T t);
    
    public boolean update(T t);
    
    public boolean deleteById(int id);
}
