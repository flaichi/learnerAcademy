package com.fl.school.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "classroom_tbl")
public class Classroom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "class_id")
	private Long classId;
	
	@Column(name = "class_name", unique = true)
	private String className; 
	
	@OneToMany(mappedBy = "classRoom",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Student> students = new ArrayList<>();
	
//	@OneToMany(mappedBy = "classroom",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
//    private Set<ClassSubject> classSubject = new HashSet<>();

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

//	public Set<ClassSubject> getClassSubject() {
//		return classSubject;
//	}
//
//	public void setClassSubject(Set<ClassSubject> classSubject) {
//		this.classSubject = classSubject;
//	}	
		
}
