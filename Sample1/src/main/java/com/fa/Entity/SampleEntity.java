package com.fa.Entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="sample")
public class SampleEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name="user")
private String userName;

@Column(name="password")
private String password;

@Column(name="created_by")
private String createdBy;

@Column(name="created_date")
private String createdDate;

@Column(name="empid")
private String empId;

@Column(name="email")
private String email;

@Column(name="skills")
private String skill;

@Column(name = "file_name")
private String fileName;

@Column(name = "file_type")
private String fileType;

@Lob
private byte[] data;

public SampleEntity() {
	super();
}



public SampleEntity(Long id, String userName, String password, String createdBy, String createdDate, String empId,
		String email, String skill, String fileName, String fileType, byte[] data) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.createdBy = createdBy;
	this.createdDate = createdDate;
	this.empId = empId;
	this.email = email;
	this.skill = skill;
	this.fileName = fileName;
	this.fileType = fileType;
	this.data = data;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileType() {
	return fileType;
}

public void setFileType(String fileType) {
	this.fileType = fileType;
}

public byte[] getData() {
	return data;
}

public void setData(byte[] data) {
	this.data = data;
}

@Override
public String toString() {
	return "SampleEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", createdBy=" + createdBy
			+ ", createdDate=" + createdDate + ", empId=" + empId + ", email=" + email + ", skill=" + skill
			+ ", fileName=" + fileName + ", fileType=" + fileType + ", data=" + Arrays.toString(data) + "]";
}



}
