package dto;
import java.io.Serializable;

public class StampLog implements Serializable{
	
	private int id;
	private int student_id;
	private int stamp_id;
	private String text;
	private int reaction_id;
	private boolean is_read;
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
	public int getStamp_id() {
		return stamp_id;
	}
	public void setStamp_id(int stamp_id) {
		this.stamp_id = stamp_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getReaction_id() {
		return reaction_id;
	}
	public void setReaction_id(int reaction_id) {
		this.reaction_id = reaction_id;
	}
	public boolean getIsRead() {
		return is_read;
	}
	public void setIsRead(boolean is_read) {
		this.is_read = is_read;
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
	public StampLog(int id, int student_id, int stamp_id, String text, int reaction_id, boolean is_read, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.stamp_id = stamp_id;
		this.text = text;
		this.reaction_id = reaction_id;
		this.is_read = is_read;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public StampLog() {
		super();
		this.id = 0;
		this.student_id = 0;
		this.stamp_id = 0;
		this.text = "";
		this.reaction_id = 0;
		this.is_read = false;
		this.created_at = "";
		this.updated_at = "";
	}
}
