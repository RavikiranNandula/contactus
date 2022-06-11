package com;


public class Request {
	Integer id;
	String fullname;
	String email;
	String message;
	Integer Status;
	public Request(){
		
	}
	Request(int id){
		this.id=id;
	}
	Request(String fullname,String email,String message){
		this.fullname=fullname;
		this.email=email;
		this.message=message;
	}
	public Request(int id, String fullname,String email, String message,Integer requestStatus){
		this.id=id;
		this.fullname=fullname;
		this.email=email;
		this.message=message;
		this.Status=requestStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
