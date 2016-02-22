package ruanko.shortrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ruanko.shortrent.entity.days;
import ruanko.shortrent.entity.indent;

public class indentDao extends BaseDao{
	public void add(indent indent) {
		String sql1 = "INSERT INTO indent(renter_id,indent_check_in_time,indent_leave_time,indent_state,house_id) VALUES('" +
				indent.getRenter_id() +
				"','" +
				indent.getIndent_check_in_time() +
				"','" +
				indent.getIndent_leave_time() +
				"','"+
				indent.getIndent_state() +
				"','"+
				indent.getHouse_id() +
				"')";
		String sql2="call gendays('"+indent.getIndent_check_in_time()+"' ,' "+indent.getIndent_leave_time()+"' ,' "+indent.getHouse_id()+"');";
		executeUpdate(sql1);
		executeUpdate(sql2);
	}
	
	

	/**
	 * 删除
	 * @param id
	 */
	public void delete(int indent_id) {
		String sql = "DELETE FROM indent WHERE indent_id=" + indent_id;
		executeUpdate(sql);
	}
	
public void update(int indent_id) throws SQLException  {
	
		
		Connection conn = getConnection();

		String sql = "update indent set indent_state ='y' where indent_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, indent_id);
		
		pstmt.executeUpdate();
		

		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 得到一个文章
	 * @param id 
	 * 			文章编号
	 * @return 文章
	 */
	public indent get(int indent_id) {
		
		String sql = "SELECT * FROM v_indent WHERE user_id=" + indent_id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				indent.setIndent_state(resultSet.getString("indent_state"));
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				

				closeAll(connection, statement, resultSet);
				return indent;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到所有订单
	 */
	public List<indent> getAll(int id){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent where renter_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				indent.setIndent_state(resultSet.getString("indent_state"));
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * 得到所有未处理订单
	 */
	public List<indent> getAllno(int id){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent where indent_state='n' and host_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				indent.setHost_id(resultSet.getInt("host_id"));
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/**
	 * 得到所有已处理订单
	 */
	public List<indent> getAllyes(int id){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent where indent_state='y' and host_id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				indent.setHost_id(resultSet.getInt("host_id"));
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	public List<days> getday(int id){
		List<days> day;
		String sql = "SELECT * FROM days where id="+id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			day = new ArrayList<days>();
			while (resultSet.next()) {
			    days days=new days();
				
				days.setDays((resultSet.getString("days")));
			
				
				day.add(days);
			}
			closeAll(connection, statement, resultSet);
			return day;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 得到所有订单
	 */
	public List<indent> getAll(){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				indent.setIndent_state(resultSet.getString("indent_state"));
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * 得到所有未处理订单
	 */
	public List<indent> getAllno(){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent where indent_state='n'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/**
	 * 得到所有已处理订单
	 */
	public List<indent> getAllyes(){
		List<indent> indent1;
		String sql = "SELECT * FROM v_indent where indent_state='y'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			indent1 = new ArrayList<indent>();
			while (resultSet.next()) {
				indent indent = new indent();
				indent.setIndent_id(resultSet.getInt("indent_id"));
				indent.setHouse_name(resultSet.getString("house_name"));
				indent.setHouse_type(resultSet.getString("house_type"));
				indent.setIndent_check_in_day(resultSet.getString("indent_check_in_day"));
				indent.setRenter_name(resultSet.getString("renter_name"));
				indent.setRenter_sex(resultSet.getString("renter_sex"));
				indent.setRenter_tel(resultSet.getString("renter_tel"));
				indent.setTot_amt(resultSet.getString("tot_amt"));
				indent.setRenter_id(Integer.parseInt((resultSet.getString("renter_id"))));
				indent.setIndent_check_in_time((resultSet.getString("indent_check_in_time")));
				indent.setIndent_leave_time((resultSet.getString("indent_leave_time")));
				
				indent.setHouse_id(Integer.parseInt((resultSet.getString("house_id"))));
				
				indent1.add(indent);
			}
			closeAll(connection, statement, resultSet);
			return indent1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
