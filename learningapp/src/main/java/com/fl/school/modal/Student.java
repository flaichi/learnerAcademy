package com.fl.school.modal;

import javax.persistence.*;


@Entity
@Table(name = "student_tbl")
public class Student {
	@Id
	@GeneratedValue 
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "mobile")
	private String mobile;	
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Classroom classRoom;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Classroom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(Classroom classRoom) {
		this.classRoom = classRoom;
	}

	public Student(Long studentId, String firstName, String lastName, String email, String mobile) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		
	}
	
	public Student() {
		
	}	

}
