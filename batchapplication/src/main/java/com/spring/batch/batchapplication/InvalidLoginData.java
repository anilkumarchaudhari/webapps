package com.spring.batch.batchapplication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvalidLoginData {
  @Id
  private int id ;
  private int count;
  private String email;
  private String reason;
  
  
public InvalidLoginData(int id, int count, String email, String reason) {
	
	this.id = id;
	this.count = count;
	this.email = email;
	this.reason = reason;
}
public InvalidLoginData() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
@Override
public String toString() {
	return "InvalidLoginData [id=" + id + ", count=" + count + ", email=" + email + ", reason=" + reason + "]";
}
  
}
