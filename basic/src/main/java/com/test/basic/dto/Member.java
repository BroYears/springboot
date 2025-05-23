package com.test.basic.dto;

public class Member {
	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	public Member() {
	
	}
	
	
	
	public Member(Long seq, String name, Integer age, String address, String gender) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		
	}

	public Member(Long seq, String name, String gender) {
		super();
		this.seq = seq;
		this.name = name;
		this.gender = gender;
		
	}
	
	

	@Override
	public String toString() {
		return "Member [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ "]";
	}
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
