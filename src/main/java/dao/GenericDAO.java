package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDAO <T> {
	public ArrayList<T> findAll()throws SQLException;

	public int insert(T t) throws SQLException;

	public int insert(T t, T y) throws SQLException;

	public int update(T t)throws SQLException;

	public int delete(T t) throws SQLException;
}
