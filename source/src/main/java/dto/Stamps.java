package dto;

import java.io.Serializable;

//岩本//
public class Stamps implements Serializable{
	private int id;
	private String login_id;
	private String login_pass;
	private int type;
	private String created_at;
	private String updated_at;
	public int getId() {
		return id;
}
	
}