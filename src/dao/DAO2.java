package dao;

import java.sql.SQLException;

public interface DAO2 <T>{
	public int insert(T t, T y)throws SQLException;
}
