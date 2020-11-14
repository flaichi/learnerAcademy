package com.fl.school.dao;

import java.util.List;

import com.fl.school.modal.Subject;
 
public interface SubjectDao {
	
	void saveSubject(Subject subject);

	void updateSubject(Subject subject);

	void deleteSubject(Long id);

	Subject  findSubjectById(Long id);

	List<Subject> findAllSubjects();

}
