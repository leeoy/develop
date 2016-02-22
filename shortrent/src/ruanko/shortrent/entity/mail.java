package ruanko.shortrent.entity;

public class mail {
	
	private int mail_id;
	private int sender_id;
	private int receiver_id;
	private String mail_note;
	private String mail_time;
	private String mail_state;
	private String mail_statechecky;
	private String mail_statecheckn;
	public int getMail_id() {
		return mail_id;
	}
	public void setMail_id(int mailId) {
		mail_id = mailId;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int senderId) {
		sender_id = senderId;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiverId) {
		receiver_id = receiverId;
	}
	public String getMail_note() {
		return mail_note;
	}
	public void setMail_note(String mailNote) {
		mail_note = mailNote;
	}
	public String getMail_time() {
		return mail_time;
	}
	public void setMail_time(String mailTime) {
		mail_time = mailTime;
	}
	public String Gettitlename(String arg,int len)
	{   
		String ntitle = arg;    
		if(ntitle.length()>len)        
			ntitle = ntitle.substring(0,len-1)+"...";   
		return ntitle;
	}
	public  String pdzt(String mail_state)
	{
		String a=mail_state;
		if(a.equals("n"))
			return "Î´¶Á";
		else
		return "ÒÑ¶Á";
		
	}
	public String fpdztn(String mail_state)
	{
		String a=mail_state;
		if(a.equals("n"))
			return "checked";
		else
		return "";
		
	}
	public String fpdzty(String mail_state)
	{
		String a=mail_state;
		if(a.equals("y"))
			return "checked";
		else
		return "";
		
	}
	public void setMail_state(String mail_state) {
		this.mail_state = mail_state;
	}
	public String getMail_state() {
		return mail_state;
	}
	public void setMail_statechecky(String mail_statechecky) {
		this.mail_statechecky = mail_statechecky;
	}
	public String getMail_statechecky() {
		return mail_statechecky;
	}
	public void setMail_statecheckn(String mail_statecheck2) {
		this.mail_statecheckn = mail_statecheck2;
	}
	public String getMail_statecheckn() {
		return mail_statecheckn;
	}

	
}
