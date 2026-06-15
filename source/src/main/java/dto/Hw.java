package dto;
import java.io.Serializable;

public class Hw implements Serializable{
	
	private int id;
	private String hw_name;
	private String created_at;
	private String updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHw_name() {
		return hw_name;
	}
	public void setHw_name(String hw_name) {
		this.hw_name = hw_name;
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
	
	public Hw(int id, String hw_name, String created_at, String updated_at) {
		super();
		this.id = id;
		this.hw_name = hw_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Hw() {
		super();
		this.id = 0;
		this.hw_name = "";
		this.created_at = "";
		this.updated_at = "";
	}
}
