package net.gestion.pgpu.dao;


import javax.sql.DataSource;
import java.util.List;

public interface DAOTemplete<T> {

	public void setDataSource(DataSource ds);

	boolean create(T obj);
	
	boolean delete(int id);

	boolean delete(T obj);

	boolean update(T obj);

	T find(int id);

	List<T> findAll();

	
}
