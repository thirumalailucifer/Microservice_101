package com.example.trial.model;

public class Uservalidate {
	
	private int uid;
	private String password;
	public Uservalidate(int uid, String password) {
		this.uid = uid;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Uservalidate [uid=" + uid + ", password=" + password + "]";
	}
}
