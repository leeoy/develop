package ruanko.shortrent.biz;

import java.sql.SQLException;
import java.util.List;

import ruanko.shortrent.dao.indentDao;
import ruanko.shortrent.entity.days;
import ruanko.shortrent.entity.indent;

public class indentBiz {
	private indentDao indentDao;

	public indentBiz() {
		this.indentDao = new indentDao();
	}
	public void add(indent indent) {
		indentDao.add(indent);
	}
	public void delete(int indent_id) {
		indentDao.delete(indent_id);
	}
	
	public void  update(int indent_id) throws SQLException {
		indentDao.update(indent_id);
	}
	
	public indent get(int indent_id) {
		return indentDao.get(indent_id);
	}
	

	public List<indent> getAll(int id){
		return indentDao.getAll(id);
	}
	public List<indent> getAllno(int id){
		return indentDao.getAllno(id);
	}
	public List<indent> getAllyes(int id){
		return indentDao.getAllyes(id);
	}
	
	
	public List<indent> getAll(){
		return indentDao.getAll();
	}
	public List<indent> getAllno(){
		return indentDao.getAllno();
	}
	public List<indent> getAllyes(){
		return indentDao.getAllyes();
	}
	public List<days> getday(int id){
		return indentDao.getday(id);
	}
	
	
}
