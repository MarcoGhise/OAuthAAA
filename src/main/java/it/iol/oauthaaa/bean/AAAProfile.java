package it.iol.oauthaaa.bean;

public class AAAProfile {

	private String nick;
	private String email;
	
	public AAAProfile(String nick, String email)
	{
		this.setNick(nick);
		this.setEmail(email);				
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

　
　
	public String getNick() {
		return nick;
	}

　
　
	public void setNick(String nick) {
		this.nick = nick;
	}

}
