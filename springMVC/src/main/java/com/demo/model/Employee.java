package com.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Employee {
	@NotEmpty
  private int empid;
   public Employee(int empid, String empname) {
	super();
	this.empid = empid;
	this.empname = empname;
}
   @NotEmpty
private String empname;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}


}
