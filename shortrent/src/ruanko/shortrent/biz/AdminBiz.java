package ruanko.shortrent.biz;

import ruanko.shortrent.dao.AdminDao;
import ruanko.shortrent.entity.Admin;

public class AdminBiz {
	private AdminDao adminDao;
	
	public AdminBiz() {
		this.adminDao = new AdminDao();
	}

	public Admin adminlogin(String admin_name, String admin_password) {
			return adminDao.adminlogin(admin_name,admin_password);
	}

}
