package com.fl.school.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
 
@Entity
@Table(name = "subject_tbl")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subject_id")	 
	private Long subjectId;
	
	@Column(name = "subject_name") 
	private String subjectName;
	
	@Column(name = "subject_code")	 
	private String subjectCode;
	
	//The mapped Entity subject with teacher is listed here in subject persistent class.
	@ManyToMany(mappedBy="subjects")	
	Set<Teacher> teachers = new HashSet<>();


	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
}
