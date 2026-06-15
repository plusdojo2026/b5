package dto;
import java.io.Serializable;

public class Users implements Serializable{
	
	private int id;
	private String login_id;
	private String login_pass;
	private int type;
	private String created_at;
	private String updated_at;
	
	//須藤が編集しちゃったよ～～～～～～ん
	
	
	//ゲッタセッタ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	//コンストラクタ
	public Users(int id, String login_id, String login_pass, int type, String created_at, String updated_at) {
		super();
		this.id = id;
		this.login_id = login_id;
		this.login_pass = login_pass;
		this.type = type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Users() {
		super();
		this.id = 0;
		this.login_id = "";
		this.login_pass = "";
		this.type = 0;
		this.created_at = "";
		this.updated_at = "";
	}
}
