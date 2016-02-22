package ruanko.shortrent.biz;

import java.util.List;

import ruanko.shortrent.dao.UserDao;
import ruanko.shortrent.entity.User;

public class UserBiz {
	private UserDao userDao;

	public UserBiz() {
		this.userDao = new UserDao();
	}
	public void add(User user) {
		userDao.add(user);
	}
	public void delete(int user_id) {
		userDao.delete(user_id);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
	public User get(int user_id) {
		return userDao.get(user_id);
	}
	
	public List<User> getAll(){
		return userDao.getAll();
	}
	public void Pwdupdate(User user) {
		userDao.Pwdupdate(user);
		
	}
	public User login(String user_account, String user_password) {
		return userDao.login(user_account,user_password);
	}
	public User pwdback(String user_answer) {
		return userDao.pwdback(user_answer);
	}
	public User pwdbackun(String user_account) {
		return userDao.pwdbackun(user_account);
	}
	
}
