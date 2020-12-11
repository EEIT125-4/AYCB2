package message.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_table")
public class MessageBean {
	@Id
	@Column(columnDefinition = "NVARCHAR(11)")
	String id;
	@Column(columnDefinition = "NVARCHAR(MAX) NOT NULL")
	private String content,title ;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String type; 
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String imgpath;
		
	private Date date;
	private Date editDate;

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public MessageBean() {

	}

	public MessageBean(String msg_id, String msg_title, String msg_desc, String msg_type, String msg_imgpath,
			Date msg_Date) {
		super();
		this.id = msg_id;
		this.title = msg_title;
		this.content = msg_desc;
		this.type = msg_type;
		this.imgpath = msg_imgpath;
		this.date = msg_Date;
	}
	
	
	
	public MessageBean(String msg_title, String msg_desc, String msg_type, String msg_imgpath,
			Date msg_Date) {
		super();
		
		this.title = msg_title;
		this.content = msg_desc;
		this.type = msg_type;
		this.imgpath = msg_imgpath;
		this.date = msg_Date;
	}

	public String getMsg_id() {
		return id;
	}

	public void setMsg_id(String msg_id) {
		this.id = msg_id;
	}

	public String getMsg_title() {
		return title;
	}

	public void setMsg_title(String msg_title) {
		this.title = msg_title;
	}

	public String getMsg_desc() {
		return content;
	}

	public void setMsg_desc(String msg_desc) {
		this.content = msg_desc;
	}

	public String getMsg_type() {
		return type;
	}

	public void setMsg_type(String msg_type) {
		this.type = msg_type;
	}

	public String getMsg_imgpath() {
		return imgpath;
	}

	public void setMsg_imgpath(String msg_imgpath) {
		this.imgpath = msg_imgpath;
	}

	public Date getMsg_Date() {
		return date;
	}

	public void setMsg_Date(Date msg_Date) {
		this.date = msg_Date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageBean [id=");
		builder.append(id);
		builder.append(", content=");
		builder.append(content);
		builder.append(", type=");
		builder.append(type);
		builder.append(", title=");
		builder.append(title);
		builder.append(", imgpath=");
		builder.append(imgpath);
		builder.append(", date=");
		builder.append(date);
		builder.append(", editDate=");
		builder.append(editDate);
		builder.append("]");
		return builder.toString();
	}

}
