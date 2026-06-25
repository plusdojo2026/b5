package dto;
import java.io.Serializable;

public class ItemLists  implements Serializable {
	private int id;
	private String date;
	private int grade ;
	private int class_number;
	private int item_id;
	private String item_name;
	private String created_at;
	private String updated_at;
	public int getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
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
	public void setId(int id) {
		this.id = id;
	}
	public ItemLists(int id, String date, int grade, int class_number, int item_id, String item_name, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.date = date;
		this.grade = grade;
		this.class_number = class_number;
		this.item_id = item_id;
		this.item_name = item_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public ItemLists() {
		super();
		this.id = 0;
		this.date = "";
		this.grade = 0;
		this.class_number = 0;
		this.item_id = 0;
		this.item_name = "";
		this.created_at = "";
		this.updated_at = "";
}
}