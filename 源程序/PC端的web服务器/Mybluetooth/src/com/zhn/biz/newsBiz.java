package com.zhn.biz;

import java.sql.SQLException;
import java.util.List;

import com.zhn.dao.newsDao;
import com.zhn.entity.news;
public class newsBiz {
	private newsDao newsDao;

	public newsBiz() {
		this.newsDao = new newsDao();
	}
	public void add(news news) {
		newsDao.add(news);
	}
	public void delete(String mac) {
		newsDao.delete(mac);
	}
	public news get(String mac) {
		return newsDao.get(mac);
	}
	public List<news> getAll(){
		return newsDao.getAll();
	}
	public void update(String mac,String note) throws SQLException{
		newsDao.update(mac, note);
	}
}
