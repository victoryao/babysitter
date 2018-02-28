package entity;

import java.util.Date;

public class ClassDO {
	
	private int id;
	private int cId;
	private String subject;
	private String content;
	private int status;	//0:上线 1:下线
	private int type;	//0:普通 1:置顶
	private Date created;
	private Date updated;
	
	public ClassDO() {
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public ClassDO(String subject, String content) {
		this.subject = subject;
		this.content = content;
		this.created = new Date();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ClassDO [id=" + id + ", cId=" + cId + ", subject=" + subject
				+ ", content=" + content + ", status=" + status + ", type="
				+ type + ", created=" + created + ", updated=" + updated + "]";
	}
}
