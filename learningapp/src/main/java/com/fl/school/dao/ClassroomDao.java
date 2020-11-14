package com.fl.school.dao;

import java.util.List;

import com.fl.school.modal.Classroom;
 

public interface ClassroomDao {
	void saveClass(Classroom classroom);

	void updateClassroom(Classroom classroom);

	void deleteClassroom(Long id);

	Classroom findClassroomById(Long id);

	List<Classroom> findAllClassrooms();

}
