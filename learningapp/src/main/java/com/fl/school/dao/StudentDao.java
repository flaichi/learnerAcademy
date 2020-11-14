package com.fl.school.dao;

import java.util.List;
import com.fl.school.modal.Student;

public interface StudentDao {
	Long saveStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Long id);

	Student findStudentById(Long id);

	List<Student> findAllStudents();
}

