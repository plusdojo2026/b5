package dto;
import java.io.Serializable;

public class HwCheck implements Serializable{
	private int id;
	private String date;
	private int student_id;
	private String range;
	private String created_at;
	private String updated_at;
	
	//ゲッタセッタ
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

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
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
	public HwCheck(int id, String date, int student_id, String range, int grade, int class_number, String created_at, String updated_at) {
		super();
		this.id = id;
		this.date = date ;
		this.student_id = student_id;
		this.range = range;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public HwCheck() {
		super();
		this.id = 0;
		this.date = "";
		this.student_id = 0;
		this.range = "";
		this.created_at = "";
		this.updated_at = "";
	}
}
