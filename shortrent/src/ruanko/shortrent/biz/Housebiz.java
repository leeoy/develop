package ruanko.shortrent.biz;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import ruanko.shortrent.dao.HouseDao;
import ruanko.shortrent.entity.House;


public class Housebiz {
	private HouseDao houseDao;
	public Housebiz() {
		this.houseDao = new HouseDao();
	}
	public void addhouse(House house) throws IOException, SQLException {
		houseDao.addhouse(house);
	}
	public List<House> getsearch1(String a,String b,String c,String d,String e){
		return houseDao.getsearch1(a,b,c,d,e);
	}
	

	
	public List<House> getsearch(String a){
		return houseDao.getsearch(a);
	}
	public List<House> getAll(String state){
		return houseDao.getAll(state);
	}
	public Vector<House> gethouseById(int houseid) {
		return houseDao.getByhouseId(houseid);
	}

	public Vector<House> gethouse(int ownerId) {
		return houseDao.gethouse(ownerId);
	}

	public void changehouse(House house) throws SQLException {
		houseDao.changehouse(house);
	}
	public void delhouse(int id) throws SQLException {
		houseDao.delhouse(id);
		
	}
	public InputStream getimage(int id) throws SQLException {
		return houseDao.getimage(id);
	}
	public Vector<House> foundhousebystate(String state) {
		return houseDao.foundhousebystate(state);
	}
	public void ChangeHouseState(int houseid) throws SQLException {
		houseDao.ChangehouseState(houseid);
	}
	public House housefoundimg(int id) {
		return houseDao.housefoundimg(id);
	}
	public void addhouseimg(House house, int id) throws SQLException {
		houseDao.addhouseimg(house,id);
		
	}

}
