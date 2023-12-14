package com.example.trial.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
 @Id
 private int uid;
 private String uname;
 private String password;
public int getUid() {
		return uid;
	}
public void setUid(int uid) {
		this.uid = uid;
	}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [uname=" + uname + ", uid=" + uid + ", password=" + password + "]";
}
}

