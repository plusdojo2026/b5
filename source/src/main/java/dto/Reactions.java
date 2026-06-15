package dto;
import java.io.Serializable;

public class Reactions implements Serializable{
	
	private int id;
	private String reaction_name;
	private String reaction_url;
	private String created_at;
	private String updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReaction_name() {
		return reaction_name;
	}
	public void setReaction_name(String reaction_name) {
		this.reaction_name = reaction_name;
	}
	public String getReaction_url() {
		return reaction_url;
	}
	public void setReaction_url(String reaction_url) {
		this.reaction_url = reaction_url;
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
	
	public Reactions() {
		super();
		this.id = 0;
		this.reaction_name = "";
		this.reaction_url = "";
		this.created_at = "";
		this.updated_at = "";
	}
	public Reactions(int id, String reaction_name, String reaction_url, String created_at, String updated_at) {
		super();
		this.id = id;
		this.reaction_name = reaction_name;
		this.reaction_url = reaction_url;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
}
