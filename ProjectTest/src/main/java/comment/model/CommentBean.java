package comment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class CommentBean{
	
	@Id
	// 當使用IDENTITY時，主要鍵的資料型態必須是整數或符點數，不可以為char或String
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commentId;	
	
	private Integer id;
	@Column(columnDefinition= "NVARCHAR(MAX) NOT NULL")
	private String name;
	private String gender;
	private Integer age;
	private String commentTime;
	private String contentBox;
	private Integer status;
	

	public CommentBean() {
	}

	public CommentBean(Integer pId,Integer pCommentID,String pName, String pGender, Integer pAge, Integer pStatus, String pCommentTime,
			String pContentBox) {
		this.id=pId;
		this.commentId=pCommentID;
		this.name = pName;
		this.gender = pGender;
		this.age = pAge;
		this.status = pStatus;
		this.commentTime = pCommentTime;
		this.contentBox = pContentBox;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getContentBox() {
		return contentBox;
	}

	public void setContentBox(String contentBox) {
		this.contentBox = contentBox;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentBean [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", commentId=");
		builder.append(commentId);
		builder.append(", commentTime=");
		builder.append(commentTime);
		builder.append(", contentBox=");
		builder.append(contentBox);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}


	
}
