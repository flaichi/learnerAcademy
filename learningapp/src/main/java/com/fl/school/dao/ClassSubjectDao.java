package com.fl.school.dao;

import java.util.List;

import com.fl.school.modal.ClassSubject;
import com.fl.school.modal.Student;
import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;


public interface ClassSubjectDao {

	void saveClassSubject(ClassSubject classroom);

	void updateClassSubject(ClassSubject classroom);

	void deleteClassSubject(Long id);

	ClassSubject findClassSubjectById(Long id);

	List<ClassSubject> findAllClassSubjects();
	
	List<Subject> findAllSubjectsByCalssId(Long classId);
	
	List<Teacher> findAllTeachersByCalssId(Long classId);
	
	List<Student> findAllStudentsByCalssId(Long classId);
	
}
