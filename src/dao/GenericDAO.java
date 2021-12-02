package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO <T> {
	public int update(T t)throws SQLException;
	public ArrayList<T> findAll()throws SQLException;
}
