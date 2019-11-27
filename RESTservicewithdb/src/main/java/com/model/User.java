package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@Entity
@ Table(name="userauto")
@XmlRootElement
@XmlType(propOrder={"userId","userName","password"})
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId",length=4)
     private int userId;
	@Column(name="userName",length=25)
     private String userName;
	@Column(name="password",length=25)
     private String password;
     
     public User(){
 		super();
 	}
 	
   public int getUserId() {
	return userId;
   }
    public void setUserId(int userId) {
	this.userId = userId;
   }
    public String getUserName() {
	return userName;
   }
   public void setUserName(String userName) {
	this.userName = userName;
   }
    public String getPassword() {
	return password;
   }
   public void setPassword(String password) {
	this.password = password;
   }
}
