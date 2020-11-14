package com.fl.school.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "classsubject_tbl")
public class ClassSubject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="class_id")
	private Long classId;
	
	@Column(name="subject_id")
	private Long subjectId;
	
	@Column(name="teacher_id")
	private Long teacherId;

	public Long getId() {
		return id;
	}
	
	
	@Transient
	private Classroom classroom;
	@Transient
	private Subject subject;
	@Transient
	private Teacher teacher;

	
//	@ManyToOne
//	@JoinColumn(name = "class_id")
//	private Classroom classroom;
//
//	@ManyToOne
//	@JoinColumn(name = "subject_id")
//	private Subject subject;
//	
//	@ManyToOne
//	@JoinColumn(name = "teacher_id")
//	private Teacher teacher;



	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}	

//	public Classroom getClassroom() {
//		return classroom;
//	}
//
//	public void setClassroom(Classroom classroom) {
//		this.classroom = classroom;
//	}
//
//	public Subject getSubject() {
//		return subject;
//	}
//
//	public void setSubject(Subject subject) {
//		this.subject = subject;
//	}
//
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}

}
