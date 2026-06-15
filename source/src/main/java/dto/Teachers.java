package dto;

import java.io.Serializable;

public class Teachers implements Serializable{
	private int id;
	private int user_id;
	private String name;
	private int grade;
	private int class_number;
	private String created_at;
	private String updated_at;
	
	//ゲッタセッタ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClass_number() {
		return class_number;
	}
	public void setClass_number(int class_number) {
		this.class_number = class_number;
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
	
	
	public Teachers(int id, int user_id, String name, int grade, int class_number, String created_at, String updated_at) {
		super();
		this.id = id;
		this.user_id= user_id ;
		this.name = name;
		this.grade = grade;
		this.class_number = class_number;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Teachers() {
		super();
		this.id = 0;
		this.user_id= 0;
		this.name = "";
		this.grade = 0;
		this.class_number = 0;
		this.created_at = "";
		this.updated_at = "";
	}
}


