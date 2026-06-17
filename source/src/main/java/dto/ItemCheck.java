package dto;
import java.io.Serializable;

public class ItemCheck implements Serializable{
	
	private int id;
	private int student_id;
	private String date;
	private int item_id;
	private String item_name;
	private boolean is_checked;
	private String created_at;
	private String updated_at;
	
	//ゲッターセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public boolean isIs_checked() {
		return is_checked;
	}
	public void setIs_checked(boolean is_checked) {
		this.is_checked = is_checked;
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
	
	public ItemCheck(int id, int student_id, String date, int item_id, boolean is_checked, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.date = date;
		this.item_id = item_id;
		this.is_checked = is_checked;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public ItemCheck() {
		super();
		this.id = 0;
		this.student_id = 0;
		this.date = "";
		this.item_id = 0;
		this.is_checked = false;
		this.created_at = "";
		this.updated_at = "";
	}
	
}
