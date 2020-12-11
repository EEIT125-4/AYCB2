package event;

public class EventBean
{
  String Name;
  String Phone;
  String Mailaddress;
  String Eventname;
  String Eventdate;
 
 public EventBean() {
	
}
  
  public EventBean(String name, String phone,String mailaddress,
          String eventname ,String eventdate )
{
this.Name = name;
this.Phone = phone;
this.Mailaddress = mailaddress;
this.Eventname = eventname;
this.Eventdate = eventdate;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
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

public String getEventdate() {
	return Eventdate;
}

public void setEventdate(String eventdate) {
	Eventdate = eventdate;
}

public String getEventname() {
	return Eventname;
}

public void setEventname(String eventname) {
	Eventname = eventname;
}


  

}