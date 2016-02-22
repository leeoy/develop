package ruanko.shortrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ruanko.shortrent.entity.User;

public class UserDao extends BaseDao{
		
	public void add(User user) {
		String sql = "INSERT INTO users(user_account,user_password,user_question,user_answer,user_name,user_sex,user_phone) VALUES('" +
				user.getUser_account() +
				"','" +
				user.getUser_password() +
				"','" +
				user.getUser_question() +
				"','" +
				user.getUser_answer() +
				"','" +
				user.getUser_name() +
				"','"+
				user.getUser_sex() +
				"','" +
				user.getUser_phone() +
				"')";
		executeUpdate(sql);
	}
	
	

	/**
	 * 删除
	 * @param user_id
	 */
	public void delete(int user_id) {
		String sql = "DELETE FROM users WHERE user_id=" + user_id;
		executeUpdate(sql);
	}
	
	/**
	 * 更新
	 * @param user
	 * 		
	 * 
	 */
	public void update(User user) {
		
		String sql = "UPDATE users SET user_account='" +
				user.getUser_account() +
				"', user_name='" +
				user.getUser_name() +
				"',user_sex='" +
				user.getUser_sex() +
				"',user_phone='" +
				user.getUser_phone() +
				"',user_text='" +
				user.getUser_text() +
				"' WHERE user_id=" + user.getUser_id();
		executeUpdate(sql);
	}
	
	/**
	 * 得到一个用户
	 * @param id 
	 * 			用户编号
	 * @return null
	 */
	public User get(int user_id) {
		
		String sql = "SELECT * FROM users WHERE user_id=" + user_id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				User user = new User();
				user.setUser_id(resultSet.getInt("user_id"));
				user.setUser_account(resultSet.getString("user_account"));
				user.setUser_password(resultSet.getString("user_password"));
				user.setUser_name(resultSet.getString("user_name"));
				user.setUser_sex(resultSet.getString("user_sex"));
				user.setUser_phone(resultSet.getString("user_phone"));
				user.setUser_text(resultSet.getString("user_text"));

				closeAll(connection, statement, resultSet);
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到所有用户
	 * @return null
	 */
	public List<User> getAll(){
		List<User> users;
		String sql = "SELECT * FROM users";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			users = new ArrayList<User>();
			while (resultSet.next()) {
				User user = new User();
				user.setUser_id(resultSet.getInt("user_id"));
				user.setUser_account(resultSet.getString("user_account"));
				user.setUser_password(resultSet.getString("user_password"));
				user.setUser_name(resultSet.getString("user_name"));
				user.setUser_sex(resultSet.getString("user_sex"));
				user.setUser_phone(resultSet.getString("user_phone"));
				user.setUser_text(resultSet.getString("user_text"));
				users.add(user);
			}
			closeAll(connection, statement, resultSet);
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public User login(String user_account, String user_password) {
		String queryStr="select * from users where user_account=? and user_password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User result = null;
		BaseDao basedao = new BaseDao();
		if(user_account == null || user_password == null ) return result;
		try{
			conn = basedao.getConnection();
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1,user_account);
			pstmt.setString(2,user_password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = new User();
				result.setUser_account(rs.getString("user_account"));
				result.setUser_password(rs.getString("user_password"));
				result.setUser_id(Integer.parseInt((rs.getString("user_id"))));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		finally{
			basedao.closeAll(conn, pstmt, rs);
		}
		return result;
		
	}
		public User pwdback(String user_answer) {
			String queryStr="select * from users where user_answer=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			User result = null;
			BaseDao basedao = new BaseDao();
			if(user_answer == null) return result;
			try{
				conn = basedao.getConnection();
				pstmt = conn.prepareStatement(queryStr);
				pstmt.setString(1,user_answer);
				rs = pstmt.executeQuery();
				if(rs.next()){
					result = new User();
					result.setUser_id(Integer.parseInt((rs.getString("user_id"))));
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			finally{
				basedao.closeAll(conn, pstmt, rs);
			}
			return result;
		}



		public User pwdbackun(String user_account) {
			String queryStr="select * from users where user_account='"+user_account+"'";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			User result = null;
			BaseDao basedao = new BaseDao();
			if(user_account == null) return result;
			try{
				conn = basedao.getConnection();
				pstmt = conn.prepareStatement(queryStr);
				rs = pstmt.executeQuery();
				if(rs.next()){
					result = new User();
					result.setUser_question(rs.getString("user_question"));
					result.setUser_id(Integer.parseInt((rs.getString("user_id"))));
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		finally{
			basedao.closeAll(conn, pstmt, rs);
		}
		return result;
		
	}


	public void Pwdupdate(User user) {
		String sql = "UPDATE users SET user_password='" +
		user.getUser_password() +
		"' WHERE user_id=" + user.getUser_id();
		executeUpdate(sql);
		
	}
		
}
