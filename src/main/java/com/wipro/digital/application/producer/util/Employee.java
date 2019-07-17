package com.wipro.digital.application.producer.util;

public class Employee {

	private String name;
	private int empid;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", address=" + address + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int empid, String address) {
		super();
		this.name = name;
		this.empid = empid;
		this.address = address;
	}
	
	
}
