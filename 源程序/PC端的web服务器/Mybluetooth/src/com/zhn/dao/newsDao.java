package com.zhn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhn.entity.news;

public class newsDao extends BaseDao {
	public void add(news news) {
		String sql1 = "INSERT INTO news(mac,note) VALUES('" +
				news.getMac() +
				"','" +
				news.getNote() +
			
				"')";
		
		executeUpdate(sql1);
	
	}
	public void delete(String mac) {
		String sql = "DELETE FROM news WHERE mac='" + mac+"'";
		executeUpdate(sql);
	}
public void update(String mac,String note) throws SQLException  {
	
		
		Connection conn = getConnection();

		String sql = "update news set note = ? where mac =  ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, note);
		pstmt.setString(2, mac);
		pstmt.executeUpdate();
		

		pstmt.close();
		conn.close();
		
	}
public news get(String mac) {
		
		String sql = "SELECT * FROM news WHERE mac= '" + mac+"'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				news news = new news();
			
				news.setMac((resultSet.getString("mac")));
				news.setNote((resultSet.getString("note")));
				
				

				closeAll(connection, statement, resultSet);
				return news;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
public List<news> getAll(){
	List<news> news1;
	String sql = "SELECT * FROM news";
	Connection connection = getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		news1 = new ArrayList<news>();
		while (resultSet.next()) {
			news news = new news();
			
			news.setMac((resultSet.getString("mac")));
			news.setNote((resultSet.getString("note")));
		
			
			
			news1.add(news);
		}
		closeAll(connection, statement, resultSet);
		return news1;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

}
