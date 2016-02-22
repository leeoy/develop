package ruanko.shortrent.entity;

public class User {
	
	private int user_id;
	private String user_account;
	private String user_password;
	private String user_question;
	private String user_answer;
	private String user_name;
	private String user_sex;
	private String user_phone;
	private String user_text;
	
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public void setUser_text(String user_text) {
		this.user_text = user_text;
	}
	public String getUser_text() {
		return user_text;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_question(String user_question) {
		this.user_question = user_question;
	}
	public String getUser_question() {
		return user_question;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String getUser_answer() {
		return user_answer;
	}
	
}
