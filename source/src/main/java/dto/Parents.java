package dto;

import java.io.Serializable;

public class Parents implements Serializable{
	
	private int id;
	private String student_id;
	private String created_at;
	private String updated_at;
	
	//ゲッタセッタ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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
	public Parents(int id, String student_id, String created_at, String updated_at) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Parents() {
		super();
		this.id = 0;
		this.student_id = "";
		this.created_at = "";
		this.updated_at = "";
	}
}
