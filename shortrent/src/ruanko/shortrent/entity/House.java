package ruanko.shortrent.entity;

public class House {
	private int house_id;
	private int owner_id;
	private String house_name;
	private String house_address;
	private String house_type;
	private  int house_suithuman;
	private double house_price;
	private String house_support;
	private String house_state;
	private String house_img1;
	private String house_img2;
	private String house_img3;
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}
	public String getHouse_address() {
		return house_address;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_suithuman(int house_suithuman) {
		this.house_suithuman = house_suithuman;
	}
	public int getHouse_suithuman() {
		return house_suithuman;
	}
	public void setHouse_price(double house_price) {
		this.house_price = house_price;
	}
	public double getHouse_price() {
		return house_price;
	}
	public void setHouse_support(String house_support) {
		this.house_support = house_support;
	}
	public String getHouse_support() {
		return house_support;
	}
	public void setHouse_img1(String house_img1) {
		this.house_img1 = house_img1;
	}
	public String getHouse_img1() {
		return house_img1;
	}
	public void setHouse_img2(String house_img2) {
		this.house_img2 = house_img2;
	}
	public String getHouse_img2() {
		return house_img2;
	}
	public void setHouse_img3(String house_img3) {
		this.house_img3 = house_img3;
	}
	public String getHouse_img3() {
		return house_img3;
	}
	public void setHouse_state(String house_state) {
		this.house_state = house_state;
	}
	public String getHouse_state() {
		return house_state;
	}
	
}
