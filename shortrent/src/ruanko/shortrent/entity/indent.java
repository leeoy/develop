package ruanko.shortrent.entity;


public class indent {
	
	private int indent_id;
	private int renter_id;
	private String renter_name;
	private String house_type;
	private String renter_sex;
	private String renter_tel;
	private String house_name;
	private String indent_check_in_day;
	private String tot_amt;
	private String indent_check_in_time;
	private String indent_leave_time;
	private String indent_state;
	private int host_id;
	private int house_id;
	public int getIndent_id() {
		return indent_id;
	}
	public void setIndent_id(int indentId) {
		indent_id = indentId;
	}
	public int getRenter_id() {
		return renter_id;
	}
	public void setRenter_id(int renterId) {
		renter_id = renterId;
	}
	public String getIndent_check_in_time() {
		return indent_check_in_time;
	}
	public void setIndent_check_in_time(String indentCheckInTime) {
		indent_check_in_time = indentCheckInTime;
	}
	public String getIndent_leave_time() {
		return indent_leave_time;
	}
	public void setIndent_leave_time(String indentLeaveTime) {
		indent_leave_time = indentLeaveTime;
	}
	public String getIndent_state() {
		return indent_state;
	}
	public void setIndent_state(String indentState) {
		indent_state = indentState;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int houseId) {
		house_id = houseId;
	}
	public void setRenter_name(String renter_name) {
		this.renter_name = renter_name;
	}
	public String getRenter_name() {
		return renter_name;
	}
	public void setRenter_sex(String renter_sex) {
		this.renter_sex = renter_sex;
	}
	public String getRenter_sex() {
		return renter_sex;
	}
	public void setRenter_tel(String renter_tel) {
		this.renter_tel = renter_tel;
	}
	public String getRenter_tel() {
		return renter_tel;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setIndent_check_in_day(String indent_check_in_day) {
		this.indent_check_in_day = indent_check_in_day;
	}
	public String getIndent_check_in_day() {
		return indent_check_in_day;
	}
	public void setTot_amt(String tot_amt) {
		this.tot_amt = tot_amt;
	}
	public String getTot_amt() {
		return tot_amt;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
	public int getHost_id() {
		return host_id;
	}
	
	

}
