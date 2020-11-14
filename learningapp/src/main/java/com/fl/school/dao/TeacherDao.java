package com.fl.school.dao;

 

import java.util.List;
import java.util.Set;

import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;

public interface TeacherDao {
	void saveTeacher(Teacher teacher);

	void updateTeacher(Teacher teacher);

	void deleteTeacher(Long id);

	Teacher findTeacherById(Long id);

	List<Teacher> findAllTeachers();
	
	Set<Subject> findSubjectByTeacher(long teacherId);
	
	 void addTeacherSubject(Teacher teacher,Set<Subject> subjects);
	 
	 void deleteTeacherSubject(Teacher teacher);
	 
	 void updateTeacherSubject(Teacher teacher,Set<Subject> subjects);
	
	
}
