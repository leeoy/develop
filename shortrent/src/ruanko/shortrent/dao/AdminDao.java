package ruanko.shortrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ruanko.shortrent.entity.Admin;

public class AdminDao extends BaseDao{
	public Admin adminlogin(String admin_name, String admin_password) {
		String queryStr="select * from admin where admin_name=? and admin_password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin result = null;
		BaseDao basedao = new BaseDao();
		if(admin_name == null || admin_password == null ) return result;
		try{
			conn = basedao.getConnection();
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1,admin_name);
			pstmt.setString(2,admin_password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = new Admin();
				result.setAdmin_name(rs.getString("admin_name"));
				result.setAdmin_password(rs.getString("admin_password"));
				result.setAdmin_id(Integer.parseInt((rs.getString("admin_id"))));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		finally{
			basedao.closeAll(conn, pstmt, rs);
		}
		return result;
		
	}
		
}
