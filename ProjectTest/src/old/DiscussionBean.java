package old;


public class DiscussionBean  {
	private String id;
	private String name;
	private String gender;
	private Integer age;
	private Integer status;
	private String commentTime;
	private String contentBox;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DiscussionBean() {
	}

	public DiscussionBean(String pId,String pName, String pGender, Integer pAge, Integer pStatus, String pCommentTime,
			String pContentBox) {
		this.id=pId;
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

	@Override
	public String toString() {
		return "DiscussionBean [name=" + name + ", gender=" + gender + ", age=" + age + ", status=" + status
				+ ", commentTime=" + commentTime + ", contentBox=" + contentBox + ", id=" + id + "]";
	}

	
}
