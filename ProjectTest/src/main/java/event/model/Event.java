package event.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer eventID;
	String eventName;
	String eventDate; 
	String eventLocation;
	String host;
	String hostphone;
	Blob eventImg;
	
	public Event() {
		super();
		
	}
	
	
	public Event(Integer eventID, String eventName, String eventDate, String eventLocation, String host,
			String hostphone, Blob eventImg) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.host = host;
		this.hostphone = hostphone;
		this.eventImg = eventImg;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("event [eventID=");
		builder.append(eventID);
		builder.append(", eventName=");
		builder.append(eventName);
		builder.append(", eventDate=");
		builder.append(eventDate);
		builder.append(", eventLocation=");
		builder.append(eventLocation);
		builder.append(", host=");
		builder.append(host);
		builder.append(", hostphone=");
		builder.append(hostphone);
		builder.append(", eventImg=");
		builder.append(eventImg);
		builder.append("]");
		return builder.toString();
	}


	public Integer getEventID() {
		return eventID;
	}


	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventDate() {
		return eventDate;
	}


	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}


	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getHostphone() {
		return hostphone;
	}


	public void setHostphone(String hostphone) {
		this.hostphone = hostphone;
	}


	public Blob getEventImg() {
		return eventImg;
	}


	public void setEventImg(Blob eventImg) {
		this.eventImg = eventImg;
	}
	
	
	

}
