package dto;

import java.io.Serializable;

//岩本//
public class Stamps implements Serializable{
	private int id;
	private String  stamp_name;
	private String stamp_url;
	private String created_at;
	private String updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStamp_name() {
		return stamp_name;
	}
	public void setStamp_name(String stamp_name) {
		this.stamp_name = stamp_name;
	}
	public String getStamp_url() {
		return stamp_url;
	}
	public void setStamp_url(String stamp_url) {
		this.stamp_url = stamp_url;
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
	
	public Stamps(int id, String stamp_name, String stamp_url, String created_at, String updated_at) {
		super();
		this.id = id;
		this.stamp_name = stamp_name;
		this.stamp_url = stamp_url;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
		
	}
	public Stamps() {
		super();
		this.id = 0;
		this.stamp_name = "";
		this.stamp_url = "";
		this.created_at = "";
		this.updated_at = "";
}
}