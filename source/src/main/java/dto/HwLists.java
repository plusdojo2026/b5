package dto;
import java.io.Serializable;

public class HwLists implements Serializable{
	private int id;
	private String date;
	private String hw_range;
	private int grade;
	private int class_number;
	private int homework_id;
	private String created_at;
	private String updated_at;
	
//	ゲッタとセッタ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHw_range() {
		return hw_range;
	}
	public void setHw_range(String hw_range) {
		this.hw_range = hw_range;
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
	public int getHomework_id() {
		return homework_id;
	}
	public void setHomework_id(int homework_id) {
		this.homework_id = homework_id;
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
	
	public HwLists(int id, String date, String hw_range, int grade, int class_number, int homework_id, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.date = date;
		this.hw_range = hw_range;
		this.grade = grade;
		this.class_number = class_number;
		this.homework_id = homework_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public HwLists() {
		super();
		this.id = 0;
		this.date = "";
		this.hw_range = "";
		this.grade = 0;
		this.class_number = 0;
		this.homework_id = 0;
		this.created_at = "";
		this.updated_at = "";
	}
}
	

	