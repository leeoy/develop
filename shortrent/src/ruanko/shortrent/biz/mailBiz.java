package ruanko.shortrent.biz;

import java.sql.SQLException;
import java.util.List;

import ruanko.shortrent.dao.mailDao;
import ruanko.shortrent.entity.House;
import ruanko.shortrent.entity.mail;

public class mailBiz {
	private mailDao mailDao;

	public mailBiz() {
		this.mailDao = new mailDao();
	}
	public void add(mail mail) {
		mailDao.add(mail);
	}
	public void delete(int mail_id) {
		mailDao.delete(mail_id);
	}
	public void update(int mail_id,String mail_state) throws ClassNotFoundException, SQLException
	{
		
		mailDao.update(mail_id, mail_state);
		
		
	}
	public mail get(int mail_id) {
		return mailDao.get(mail_id);
	}
	
	/**
	 * 得到所有文章
	 * 
	 * @return 所有文章
	 */
	public List<mail> getAll(int id){
		return mailDao.getAll(id);
	}
	public List<mail> getAllsend(int id){
		return mailDao.getAllsend(id);
	}
	public List<mail> getAllnoread(int id){
		return mailDao.getAllnoread(id);
	}
	public List<mail> getAllread(int id){
		return mailDao.getAllread(id);
	}
	public List<House> getAllhouse(int id) {
	
		return mailDao.getAllhouse(id);
	}
	
	
}
