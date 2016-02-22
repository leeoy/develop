package ruanko.shortrent.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ruanko.shortrent.entity.House;


public class HouseDao extends BaseDao{

	public void addhouse(House house) throws IOException, SQLException {
		Connection conn = getConnection();
		try{
			PreparedStatement pstmt=conn.prepareStatement("insert into house (owner_id,house_name,house_address,house_type,house_suithuman,house_price,house_support,house_state,house_img1,house_img2,house_img3)values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,house.getOwner_id());
			pstmt.setString(2,house.getHouse_name());
			pstmt.setString(3,house.getHouse_address());
			pstmt.setString(4,house.getHouse_type());
			pstmt.setInt(5,house.getHouse_suithuman());
			pstmt.setDouble(6,house.getHouse_price());
			pstmt.setString(7,house.getHouse_support());
			pstmt.setString(8,house.getHouse_state());
			pstmt.setString(9,"haveno.jpg");
			pstmt.setString(10,"haveno.jpg");
			pstmt.setString(11,"haveno.jpg");
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		conn.close();
	}
	public Vector<House> gethouse(int id) {
		String sql = null;
			sql="SELECT * FROM house WHERE owner_id='"+ id+"'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Vector<House> list = new Vector<House>();
			while(resultSet.next()) {
                House house=new House();
				house.setHouse_id(resultSet.getInt("house_id"));
				house.setHouse_name(resultSet.getString("house_name"));
				house.setHouse_address(resultSet.getString("house_address"));
				house.setHouse_type(resultSet.getString("house_type"));
				house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
				house.setHouse_price(resultSet.getDouble("house_price"));
				house.setHouse_support(resultSet.getString("house_support"));
				house.setHouse_state(resultSet.getString("house_state"));
				house.setHouse_img1(resultSet.getString("house_img1"));
				house.setHouse_img2(resultSet.getString("house_img2"));
				house.setHouse_img3(resultSet.getString("house_img3"));
				list.add(house);
			}
			resultSet.close();
			statement.close();
			connection.close();
			return(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Vector<House> foundhousebystate(String state) {
		String sql = null;
		sql="SELECT * FROM house WHERE house_state='"+ state+"'";
	Connection connection = getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		Vector<House> list = new Vector<House>();
		while(resultSet.next()) {
            House house=new House();
			house.setHouse_id(resultSet.getInt("house_id"));
			house.setOwner_id(resultSet.getInt("owner_id"));
			house.setHouse_name(resultSet.getString("house_name"));
			house.setHouse_address(resultSet.getString("house_address"));
			house.setHouse_type(resultSet.getString("house_type"));
			house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
			house.setHouse_price(resultSet.getDouble("house_price"));
			house.setHouse_support(resultSet.getString("house_support"));
			house.setHouse_state(resultSet.getString("house_state"));
			house.setHouse_img1(resultSet.getString("house_img1"));
			house.setHouse_img2(resultSet.getString("house_img2"));
			house.setHouse_img3(resultSet.getString("house_img3"));
			list.add(house);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return(list);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	public Vector<House> getByhouseId(int houseid) {
		String sql = null;
		sql="SELECT * FROM house WHERE house_id='"+ houseid+"'";
	Connection connection = getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		Vector<House> list = new Vector<House>();
		while(resultSet.next()) {
            House house=new House();
            house.setHouse_id(resultSet.getInt("house_id"));
			house.setHouse_name(resultSet.getString("house_name"));
			house.setHouse_address(resultSet.getString("house_address"));
			house.setHouse_type(resultSet.getString("house_type"));
			house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
			house.setHouse_price(resultSet.getDouble("house_price"));
			house.setHouse_support(resultSet.getString("house_support"));
			house.setHouse_img1(resultSet.getString("house_img1"));
			house.setHouse_img2(resultSet.getString("house_img2"));
			house.setHouse_img3(resultSet.getString("house_img3"));
			list.add(house);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return(list);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	public InputStream getimage(int id) throws SQLException {
		Connection conn = getConnection();
		ResultSet rst=null;
		InputStream is=null;	
		String strSQL="SELECT house_img1 FROM house WHERE house_id=?";
		PreparedStatement pstmt=conn.prepareStatement(strSQL);
		pstmt.setInt(1, id);
		rst=pstmt.executeQuery();
		if(rst.next()){
			is=rst.getBinaryStream("house_img1");
			rst.close();
			pstmt.close();
			conn.close();
		}
		return is;
	}
	public void delhouse(int id) throws SQLException {
		Connection conn = getConnection();
		String strSQL="delete FROM house WHERE house_id=?";
		PreparedStatement pstmt=conn.prepareStatement(strSQL);
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public void changehouse(House house) throws SQLException {
		Connection conn = getConnection();
		String strSQL="update house set house_address='"+house.getHouse_address()+"',house_suithuman='"+house.getHouse_suithuman()+"',house_price='"+house.getHouse_price()+"',house_support='"+house.getHouse_support()+"' WHERE house_id=?";
		PreparedStatement pstmt=conn.prepareStatement(strSQL);
		pstmt.setInt(1,house.getHouse_id());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	public void ChangehouseState(int houseid) throws SQLException {
		Connection conn = getConnection();
		String strSQL="update house set house_state='yes' WHERE house_id=?";
		PreparedStatement pstmt=conn.prepareStatement(strSQL);
		pstmt.setInt(1,houseid);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public List<House> getsearch1(String house_type,String house_price,String house_suithuman,String house_address1, String house_address2) {
	    List<House> house1;
		String sql = "SELECT * FROM house WHERE house_type like '%" + house_type + "%' and house_address like '%"
		+ house_address1 + "%' and house_address like '%"
		+ house_address2 + "%' and house_price "+ house_price + "and house_suithuman "
		+ house_suithuman;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			house1 = new ArrayList<House>();
			while(resultSet.next()) {
				House house = new House();
				house.setHouse_id(resultSet.getInt("house_id"));
				house.setHouse_name(resultSet.getString("house_name"));
				house.setHouse_address(resultSet.getString("house_address"));
				house.setHouse_type(resultSet.getString("house_type"));
				house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
				house.setHouse_price(resultSet.getDouble("house_price"));
				house.setHouse_support(resultSet.getString("house_support"));
				house.setHouse_img1(resultSet.getString("house_img1"));
				house.setHouse_img2(resultSet.getString("house_img2"));
				house.setHouse_img3(resultSet.getString("house_img3"));
				house1.add(house);
				
				
			}
			closeAll(connection, statement, resultSet);
			return house1;
		} catch (SQLException e) {
			System.out.print("sososososos");
		}
		return null;
	}
	
	
	
	
	
	

	/**
	 * 搜索所有房屋
	 * @param a
	 * 			关键字
	 * @return 房屋
	 */
public List<House> getsearch(String a) {
	    List<House> house1;
		String sql = "SELECT * FROM house WHERE house_name like '%" + a + "%' or house_address like '%"+ a + "%' or house_type like '%"
		+ a + "%' or house_price like '%"+ a + "%' or house_support like '%"+ a+"%' or house_suithuman like '%"+a+"%'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			house1 = new ArrayList<House>();
			while(resultSet.next()) {
				House house = new House();
				house.setHouse_id(resultSet.getInt("house_id"));
				house.setHouse_name(resultSet.getString("house_name"));
				house.setHouse_address(resultSet.getString("house_address"));
				house.setHouse_type(resultSet.getString("house_type"));
				house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
				house.setHouse_price(resultSet.getDouble("house_price"));
				house.setHouse_support(resultSet.getString("house_support"));
				house.setHouse_img1(resultSet.getString("house_img1"));
				house.setHouse_img2(resultSet.getString("house_img2"));
				house.setHouse_img3(resultSet.getString("house_img3"));
				house1.add(house);
				
				
			}
			closeAll(connection, statement, resultSet);
			return house1;
		} catch (SQLException e) {
			System.out.print("sososososos");
		}
		return null;
	}
	
	
public List<House> getAll(String state) {
    List<House> house1;
	String sql = "SELECT * FROM house where house_state = '"+state+"'";
	Connection connection = getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		house1 = new ArrayList<House>();
		while(resultSet.next()) {
			House house = new House();
			house.setHouse_id(resultSet.getInt("house_id"));
			house.setHouse_name(resultSet.getString("house_name"));
			house.setHouse_address(resultSet.getString("house_address"));
			house.setHouse_type(resultSet.getString("house_type"));
			house.setHouse_suithuman(resultSet.getInt("house_suithuman"));
			house.setHouse_price(resultSet.getDouble("house_price"));
			house.setHouse_support(resultSet.getString("house_support"));
			house.setHouse_img1(resultSet.getString("house_img1"));
			house.setHouse_img2(resultSet.getString("house_img2"));
			house.setHouse_img3(resultSet.getString("house_img3"));
			house1.add(house);
			
			
		}
		closeAll(connection, statement, resultSet);
		return house1;
	} catch (SQLException e) {
		System.out.print("sososososos");
	}
	return null;
}
public House housefoundimg(int id) {
	String queryStr="select * from house where house_id='"+id+"'";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	House result = null;
	BaseDao basedao = new BaseDao();
	try{
		conn = basedao.getConnection();
		pstmt = conn.prepareStatement(queryStr);
		rs = pstmt.executeQuery();
		if(rs.next()){
			result = new House();
			result.setHouse_id(Integer.parseInt((rs.getString("house_id"))));
			result.setHouse_name(rs.getString("house_name"));
			result.setHouse_address(rs.getString("house_address"));
			result.setHouse_type(rs.getString("house_type"));
			result.setHouse_suithuman(rs.getInt("house_suithuman"));
			result.setHouse_price(rs.getDouble("house_price"));
			result.setHouse_support(rs.getString("house_support"));
			result.setHouse_img1(rs.getString("house_img1"));
			result.setHouse_img2(rs.getString("house_img2"));
			result.setHouse_img3(rs.getString("house_img3"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
finally{
	basedao.closeAll(conn, pstmt, rs);
}
return result;
}
public void addhouseimg(House house, int id) throws SQLException {
	Connection conn = getConnection();
	System.out.println(house.getHouse_img1());
	String strSQL="update house set house_img1='"+house.getHouse_img1()+"',house_img2='"+house.getHouse_img2()+"',house_img3='"+house.getHouse_img3()+"' WHERE house_id=?";
	PreparedStatement pstmt=conn.prepareStatement(strSQL);
	pstmt.setInt(1,id);
	pstmt.executeUpdate();
	pstmt.close();
	conn.close();
	
}
}
