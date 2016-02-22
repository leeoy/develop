package ruanko.shortrent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import ruanko.shortrent.entity.House;
import ruanko.shortrent.entity.mail;

public class mailDao extends BaseDao{
	public void add(mail mail) {
		String sql = "INSERT INTO mail(sender_id,receiver_id,mail_note) VALUES('" +
				mail.getSender_id() +
				"','" +
				mail.getReceiver_id() +
				"','" +
				mail.getMail_note() +
				"'"+
				
				
				")";
		executeUpdate(sql);
	}
	
	

	/**
	 * 删除
	 * @param id
	 */
	public void delete(int mail_id) {
		String sql = "DELETE FROM mail_show WHERE mail_id=" + mail_id;
		executeUpdate(sql);
	}
	

	
	/**
	 * 得到一个文章
	 * @param id 
	 * 			文章编号
	 * @return 文章
	 */
	
	public mail get(int mail_id) {
		
		String sql = "SELECT * FROM mail_show WHERE mail_id=" + mail_id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				mail mail = new mail();
				String b=mail.pdzt(resultSet.getString("mail_state"));
				mail.setMail_id(resultSet.getInt("mail_id"));
				mail.setSender_id(resultSet.getInt("sender_id"));
				mail.setReceiver_id(resultSet.getInt("receiver_id"));
				mail.setMail_note(resultSet.getString("mail_note"));
				mail.setMail_time(resultSet.getString("mail_time"));
				mail.setMail_state(b);
				

				closeAll(connection, statement, resultSet);
				return mail;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到所有未读邮件
	 * @return 所有未读邮件
	 */
	
	public List<mail> getAllnoread(int id){
		List<mail> mail2;
		String sql = "SELECT * FROM mail_show where mail_state='n' and receiver_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			mail2 = new ArrayList<mail>();
			while (resultSet.next()) {
				mail mail = new mail();
				String a=mail.Gettitlename(resultSet.getString("mail_note"),3);
				String b=mail.pdzt(resultSet.getString("mail_state"));
				
				mail.setMail_id(resultSet.getInt("mail_id"));
				mail.setSender_id(resultSet.getInt("sender_id"));
				mail.setReceiver_id(resultSet.getInt("receiver_id"));
				mail.setMail_note(a);
				mail.setMail_time(resultSet.getString("mail_time"));
				mail.setMail_state(b);
				mail2.add(mail);
			}
			closeAll(connection, statement, resultSet);
			return mail2;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改邮件状态
	 * @return 所有邮件
	 */

		
	public void update(int mail_id,String mail_state) throws ClassNotFoundException, SQLException {
	
		
		Connection conn = getConnection();

		String sql = "update mail_show set mail_state = ? where mail_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mail_state);
		pstmt.setInt(2, mail_id);
		
		pstmt.executeUpdate();
		

		pstmt.close();
		conn.close();
		
	}
	
	
	
	/**
	 * 得到所有已读邮件
	 * @return 所有已读邮件
	 */
	
	public List<mail> getAllread(int id){
		List<mail> mail2;
		String sql = "SELECT * FROM mail_show where mail_state='y'and receiver_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			mail2 = new ArrayList<mail>();
			while (resultSet.next()) {
				mail mail = new mail();
				String a=mail.Gettitlename(resultSet.getString("mail_note"),3);
				String b=mail.pdzt(resultSet.getString("mail_state"));
				
				mail.setMail_id(resultSet.getInt("mail_id"));
				mail.setSender_id(resultSet.getInt("sender_id"));
				mail.setReceiver_id(resultSet.getInt("receiver_id"));
				mail.setMail_note(a);
				mail.setMail_time(resultSet.getString("mail_time"));
				mail.setMail_state(b);
				mail2.add(mail);
			}
			closeAll(connection, statement, resultSet);
			return mail2;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 得到所有邮件
	 * @return 所有邮件，包含已读未读
	 */
	public List<mail> getAll(int id){
		List<mail> mail1;
		String sql = "SELECT * FROM mail_show where receiver_id= "+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			mail1 = new ArrayList<mail>();
			while (resultSet.next()) {
				mail mail = new mail();
				String x=resultSet.getString("mail_state");
				String a=mail.Gettitlename(resultSet.getString("mail_note"),3);
				String b=mail.pdzt(x);
				String c=mail.fpdztn(x);
				String d=mail.fpdzty(x);
				
				mail.setMail_id(resultSet.getInt("mail_id"));
				mail.setSender_id(resultSet.getInt("sender_id"));
				mail.setReceiver_id(resultSet.getInt("receiver_id"));
				mail.setMail_note(a);
				mail.setMail_time(resultSet.getString("mail_time"));
				mail.setMail_state(b);
				mail.setMail_statecheckn(c);
				mail.setMail_statechecky(d);
				mail1.add(mail);
			}
			closeAll(connection, statement, resultSet);
			return mail1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	public List<House> getAllhouse(int id) {
		

		List<House> houses;
		String sql = "SELECT * FROM houseowner where house_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			houses = new ArrayList<House>();
			while (resultSet.next()) {
				House house = new House();
			
				
				house.setHouse_id(resultSet.getInt("house_id"));
				house.setOwner_id(resultSet.getInt("user_id"));
				
				houses.add(house);
			}
			closeAll(connection, statement, resultSet);
			return houses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 得到所有邮件
	 * @return 所有邮件，包含已读未读
	 */
	public List<mail> getAllsend(int id){
		List<mail> mail1;
		String sql = "SELECT * FROM mail_show where sender_id= "+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			mail1 = new ArrayList<mail>();
			while (resultSet.next()) {
				mail mail = new mail();
				String x=resultSet.getString("mail_state");
				String a=mail.Gettitlename(resultSet.getString("mail_note"),3);
				String b=mail.pdzt(x);
				String c=mail.fpdztn(x);
				String d=mail.fpdzty(x);
				
				mail.setMail_id(resultSet.getInt("mail_id"));
				mail.setSender_id(resultSet.getInt("sender_id"));
				mail.setReceiver_id(resultSet.getInt("receiver_id"));
				mail.setMail_note(a);
				mail.setMail_time(resultSet.getString("mail_time"));
				mail.setMail_state(b);
				mail.setMail_statecheckn(c);
				mail.setMail_statechecky(d);
				mail1.add(mail);
			}
			closeAll(connection, statement, resultSet);
			return mail1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}