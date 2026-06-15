package dto;
import java.io.Serializable;

public class Items implements Serializable{
	
	private int id;
	private String item_name;
	private String created_at;
	private String updated_at;
	
	//ゲッターセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	//コンストラクタ
	public Items(int id, String item_name, String created_at, String updated_at) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Items() {
		super();
		this.id = 0;
		this.item_name = "";
		this.created_at = "";
		this.updated_at = "";
	}

}
