package org.entity;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	private String graName;
	public Student(int stuNo, String stuName, int stuAge, String graName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
	}
	private boolean stuSex;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean isStuSex() {
		return stuSex;
	}
	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}
	public Student() {
		}
	@Override
	public String toString() {
		return this.stuNo+","+this.stuName+","+this.stuAge+","+this.graName+","+this.stuSex+",";
				}
	
	public Student(int stuNo, String stuName, int stuAge, String graName, boolean stuSex) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
		this.stuSex = stuSex;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	}
}
