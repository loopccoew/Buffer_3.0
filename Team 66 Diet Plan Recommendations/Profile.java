package client;
import java.util.Date;

public class Profile {
  private long id;
  private Date creationDate = null;
  private Date birthDate = null;
  private String name = " ";
public Profile(long id, Date creationDate, Date birthDate, String name) {
	super();
	this.id = id;
	this.creationDate = creationDate;
	this.birthDate = birthDate;
	this.name = name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
public boolean  equals(Profile p) {
	boolean birthdayequals = false;
	if(p==null) return false;
	if(birthDate==null && p.birthDate==null) birthdayequals = true;
	else if(birthDate==null && p.getBirthDate()!= null) birthdayequals = false;
	else if(birthDate!=null && p.getBirthDate()== null) birthdayequals = false;
	else if(!p.birthDate.equals(birthDate)) birthdayequals = false;
	
	return birthdayequals && p.name.equals(name);
	
}
}
