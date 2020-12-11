package event.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer AId;
	@Column(columnDefinition = "nvarchar(max)")
	String MemberID;
	String Phone;
	String Mailaddress;
	String EventID;
	String Pax;
	
	public Integer getAid() {
		return AId;
	}
	public void setAId(Integer aId) {
		AId = aId;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMailaddress() {
		return Mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		Mailaddress = mailaddress;
	}
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	public String getPax() {
		return Pax;
	}
	public void setPax(String pax) {
		Pax = pax;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attendance [AId=");
		builder.append(AId);
		builder.append(", MemberID=");
		builder.append(MemberID);
		builder.append(", Phone=");
		builder.append(Phone);
		builder.append(", Mailaddress=");
		builder.append(Mailaddress);
		builder.append(", EventID=");
		builder.append(EventID);
		builder.append(", Pax=");
		builder.append(Pax);
		builder.append("]");
		return builder.toString();
	}
	public Attendance(Integer aId, String memberID, String phone, String mailaddress, String eventID, String pax) {
		super();
		AId = aId;
		MemberID = memberID;
		Phone = phone;
		Mailaddress = mailaddress;
		EventID = eventID;
		Pax = pax;
	}
	public Attendance() {
		super();
		
	}
	
    
}   
   
    
    
	

	