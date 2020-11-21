package com.fl.school.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fl.school.dao.AdminDao;
import com.fl.school.dao.AdminDaoImpl;
import com.fl.school.dao.ClassSubjectDao;
import com.fl.school.dao.ClassSubjectDaoImpl;
import com.fl.school.dao.ClassroomDao;
import com.fl.school.dao.ClassroomDaoImpl;
import com.fl.school.dao.StudentDao;
import com.fl.school.dao.StudentDaoImpl;
import com.fl.school.dao.SubjectDao;
import com.fl.school.dao.SubjectDaoImpl;
import com.fl.school.dao.TeacherDao;
import com.fl.school.dao.TeacherDaoImpl;
import com.fl.school.dao.UserDao;
import com.fl.school.modal.ClassSubject;
import com.fl.school.modal.Classroom;
import com.fl.school.modal.Student;
import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;

 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.add
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao = TeacherDaoImpl.getInstance();
	private AdminDao  adminDao = AdminDaoImpl.getInstance();
	private UserDao userDao;

	private StudentDao studentDao = StudentDaoImpl.getInstance();
	private SubjectDao subjectDao = SubjectDaoImpl.getInstance();
	private ClassroomDao classroomDao = ClassroomDaoImpl.getInstance();
	private ClassSubjectDao classsubjectDao = ClassSubjectDaoImpl.getInstance();

	
	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("====="+action);
		try {
			switch (action) {
			case "/checkuser":
				checkuser(request, response);
				break;

			case "/html/addteacher":
				addteacher(request, response);
				break;

			case "/html/deleteteacher":
				deleteteacher(request, response);
				break;

			case "/html/updateteacher":
				updateteacher(request, response);
				break;
			case "/html/listteacher":
				listteacher(request, response);
				break;
				
			case "/html/editteacher":
				editteacher(request, response);
				break;
			
			case "/html/addstudent":
				addstudent(request, response);
				break;

			case "/html/deletestudent":
				deletestudent(request, response);
				break;

			case "/html/updatestudent":
				updatestudent(request, response);
				break;

			case "/html/editstudent":
				editstudent(request, response);
				break;
			case "/html/liststudent":
				liststudents(request, response);
				break;
				
			case "/html/addsubject":
				addsubject(request, response);
				break;

			case "/html/deletesubjet":
				deletesubjet(request, response);
				break;

			case "/html/updatesubject":
				updatesubject(request, response);
				break;

			case "/html/editsubject":
				editsubject(request, response);
				break;

			case "/html/listsubjects":
				listsubject(request, response);
				break;
			case "/html/listteachersub":
				listteachersubject(request, response);
				break;	
			case "/html/addteachersub":
				addteachersub(request, response);
				break;	
			case "/html/editteachersub":
				editteachersub(request, response);
				break;	
			case "/html/updateteachersub":
				updateteachersub(request, response);
				break;		
			case "/html/deleteteachersub":
				deleteteachersub(request, response);
				break;			
				
			case "/html/addclass":
				addclass(request, response);
				break;

			case "/html/deleteclass":
				deleteclass(request, response);
				break;

			case "/html/updateclass":
				updateclass(request, response);
				break;

			case "/html/editclass":
				editclass(request, response);				
				break;
			case "/html/listclass":
				listclasses(request, response);
				break;
			case "/html/listclasssubject":
				listclasssubjects(request, response);
				break;	
			case "/html/addclasssubject":
				addClassSubject(request, response);
				break;	
			case "/html/editclasssubject":
				editClassSubject(request, response);
				break;	
			case "/html/deleteclasssubject":
				deleteClassSubject(request, response);
				break;	
			case "/html/updateclasssubject":
				updateClassSubject(request, response);
				break;		
			case "/html/classreport":
				classreport(request, response);
				break;	
			case "/html/showreport":
				showreport(request, response);
				break;		
			case "/logout":
				logout(request, response);
				break;
			
			default:
				homemenu(request,response);
				break;
				 
			}
		} catch (Exception ex) {
			
			//System.out.println("Exception Caught from switch  : ");
			System.out.println(ex.getMessage());
			//ex.printStackTrace();
		}		
	}
	private void checkuser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
{
	// get username from login form
	String user = request.getParameter("username");
	String pwd = request.getParameter("password");

	PrintWriter writer = response.getWriter();
	boolean result=false;
	try {
		result = adminDao.validateLogin(user, pwd);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	if (result) {
		HttpSession session = request.getSession();
		session.setAttribute("admin", user);
		request.getRequestDispatcher("/html/loginSuccess.jsp").include(request, response);
	} else {
		request.getRequestDispatcher("/html/login.jsp").include(request, response);
		writer.println("<h3 style='color:red;'>Invalid Credentials..</h3>");
	}
	
}
	
	private void addteacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("addTeacher");

			//String techId = request.getParameter("id");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			// add list of subject (subjects) objects and add to the below constructirs 

			//Teacher teacher = new Teacher(firstName, lastName, email, mobile, subjects);
			Teacher teacher = new Teacher();
            teacher.setFirstName(firstName);
            teacher.setLastName(lastName);
            teacher.setEmail(email);
            teacher.setMobile(mobile);
 
			teacherDao.saveTeacher(teacher);
			/*else {
				 
				teacherDao.updateTeacher(teacher);
			}*/
			List<Teacher> teachers = teacherDao.findAllTeachers();
			System.out.println("list of teachers " + teachers);
			request.setAttribute("teacherlist", teachers);
			request.getRequestDispatcher("/html/teacher.jsp").forward(request, response);
	}
	
	private void homemenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		System.out.println("staretd from home Mneu Login  = ");

		
		RequestDispatcher rd = request.getRequestDispatcher("html/login.jsp");
		rd.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("logout   = ");
	}
	
	private void deleteteacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String techId = request.getParameter("techId");
		System.out.println("techId from delete teacher  = "+ techId);

		if (techId == "" || techId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(techId);
			//TeacherDao teacherDao = TeacherDaoImpl.getInstance();

			teacherDao.deleteTeacher(id);
			System.out.println( "delete is done for ID"+id);
		}
		//response.sendRedirect(request.getContextPath() + "/");
		List<Teacher> teachers = teacherDao.findAllTeachers();
		System.out.println("list of teachers " + teachers);
		request.setAttribute("teacherlist", teachers);
		request.getRequestDispatcher("/html/teacher.jsp").forward(request, response);

	}

	private void updateteacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String techId = request.getParameter("techId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		System.out.println("techId from updateteacher  1  = "+ techId);

		if (techId == "" || techId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(techId);
			System.out.println("updateteacher 2 id=" +id );

			Teacher teacher = new Teacher();
			teacher.setTeacherId(id);
			teacher.setFirstName(firstName);
	        teacher.setLastName(lastName);
	        teacher.setEmail(email);
	        teacher.setMobile(mobile);

			System.out.println("TEAHCER IS CREATED");
;
			//TeacherDao teacherDao = TeacherDaoImpl.getInstance();
			teacherDao.updateTeacher(teacher);
			System.out.println("updateteacher 3 id=" +id );

			List<Teacher> teachers = teacherDao.findAllTeachers();
			System.out.println("list of teachers " + teachers);
			request.setAttribute("teacherlist", teachers);
			request.getRequestDispatcher("/html/teacher.jsp").forward(request, response);
		}
		
	}

	private void editteacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("techId"));
		System.out.println("techId from editteacher   = "+ id);
		Teacher existingTeacher = teacherDao.findTeacherById(id);
		RequestDispatcher rd = request.getRequestDispatcher("/html/teacher-form.jsp");
		request.setAttribute("teacher", existingTeacher);
		rd.forward(request, response);
		
	}

	private void addstudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("add student ....");
		
		String studId = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Long classId = Long.parseLong(request.getParameter("classId"));
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setMobile(mobile);
		
		Classroom classRoom = classroomDao.findClassroomById(classId);
		student.setClassRoom(classRoom);				
		
		if (studId == null || studId == "")			
			studentDao.saveStudent(student);
		else {
			Long id = Long.parseLong(studId);
			student.setStudentId(id);
			studentDao.updateStudent(student);
		}
		List<Student> students = studentDao.findAllStudents();
		System.out.println("list of students " + students);
		List<Classroom> classlist = classroomDao.findAllClassrooms();
		request.setAttribute("classlist", classlist);
		request.setAttribute("studentlist", students);
		request.getRequestDispatcher("/html/student.jsp").forward(request, response);
		
	}

	private void deletestudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studId = request.getParameter("studId");
		System.out.println("Deleing student ID  = "+ studId);

		if (studId == "" || studId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(studId);
			//TeacherDao teacherDao = TeacherDaoImpl.getInstance();

			studentDao.deleteStudent(id);
			System.out.println( "delete is done for ID"+id);
		}
		//response.sendRedirect(request.getContextPath() + "/");
		List<Student> student = studentDao.findAllStudents();
		request.setAttribute("studentlist", student);
		List<Classroom> classlist = classroomDao.findAllClassrooms();
		request.setAttribute("classlist", classlist);
		request.getRequestDispatcher("/html/student.jsp").forward(request, response);
		
	}
	
	private void editstudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("studId"));
		System.out.println("techId from editteacher   = "+ id);
		Student existingStudent = studentDao.findStudentById(id);
		request.setAttribute("student", existingStudent);
		List<Classroom> classlist = classroomDao.findAllClassrooms();
		request.setAttribute("classlist", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/student-form.jsp");
	
		rd.forward(request, response);
		
	}

	private void updatestudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String studId = ( request.getParameter("stuId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			Long classId = Long.parseLong(request.getParameter("classId"));
			
			System.out.println("studId from updatestudent  1  = "+ studId);
			if (studId==" " || studId == null)
				request.getRequestDispatcher("/").forward(request, response);
			else {
				Long id = Long.parseLong(studId);
				System.out.println("updatestudent 2 id=" +id );
				Student student = new Student(id, firstName, lastName, email, mobile);

				Classroom classRoom = classroomDao.findClassroomById(classId);
				student.setClassRoom(classRoom);	
				
				studentDao.updateStudent(student);
				System.out.println("updateteacher 3 id=" +id );

				List<Student> students = studentDao.findAllStudents();
				System.out.println("list of teachers " + students);
				request.setAttribute("studentlist", students);
				List<Classroom> classlist = classroomDao.findAllClassrooms() ;
				request.setAttribute("classlist", classlist);
				request.getRequestDispatcher("/html/student.jsp").forward(request, response);
			}
			
		}

	private void addsubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("add subject ....");

		String subjId = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
			
		Subject subject = new Subject();
		subject.setSubjectName(name);
		subject.setSubjectCode(code);
				
		System.out.println("name and code: ...."+ subjId+ " " + name+ " "+ code);

		if (subjId == null || subjId == "") {
			System.out.println("ging to subjetDao ....");
			subjectDao.saveSubject(subject);
		}else {
			subject.setSubjectId(Long.parseLong(subjId));;
			subjectDao.updateSubject(subject);
		}
		
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist); 		
		request.getRequestDispatcher("/html/subject.jsp").forward(request, response);

	}

	private void deletesubjet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjId = request.getParameter("subjId");
		System.out.println("studId from delete teacher  = "+ subjId);

		if (subjId == "" || subjId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(subjId);
			subjectDao.deleteSubject(id);
			System.out.println( "delete is done for ID"+id);
		}
		
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		request.getRequestDispatcher("/html/subject.jsp").forward(request, response);
		
	}

	private void editsubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("subjId"));
		System.out.println("Subject id from editsubject   = "+ id);
		Subject existingSubject = subjectDao.findSubjectById(id);
		RequestDispatcher rd = request.getRequestDispatcher("/html/subject-form.jsp");
		request.setAttribute("subject", existingSubject);
		rd.forward(request, response);
		
	}

	private void updatesubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String subjId = request.getParameter("subjId");
			String name = request.getParameter("name");
			String code = request.getParameter("code");
					
			System.out.println("studId from updatesubject  1  = "+ subjId);
			if (subjId == "" || subjId == null)
				request.getRequestDispatcher("/").forward(request, response);
			else {
				Long id = Long.parseLong(subjId);
				System.out.println("updatesubject 2 id=" +id );
								
				Subject subject = new Subject();
				subject.setSubjectId(id);
				subject.setSubjectName(name);
				subject.setSubjectCode(code);
								
				subjectDao.updateSubject(subject);

				List<Subject> subjectlist = subjectDao.findAllSubjects();
				request.setAttribute("subjectlist", subjectlist);
				request.getRequestDispatcher("/html/subject.jsp").forward(request, response);
			}
			
		}

	private void addClassSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
		
		System.out.println("add classsubject ....");

		Long classId = Long.parseLong(request.getParameter("classId"));
		Long subjectId = Long.parseLong(request.getParameter("subjectId"));
		Long teacherId = Long.parseLong(request.getParameter("teacherId"));
		
		ClassSubject classSubject = new ClassSubject();
		classSubject.setClassId(classId);
		classSubject.setSubjectId(subjectId);
		classSubject.setTeacherId(teacherId);
		
		classsubjectDao.saveClassSubject(classSubject);
		
//		Long subId = Long.parseLong(request.getParameter("subjectId"));
//		Long techId = Long.parseLong(request.getParameter("teacherId"));
//		
//		Teacher teacher = teacherDao.findTeacherById(techId);	
//		Subject subject = subjectDao.findSubjectById(subId);
		
//		
//		Classroom classroom = new Classroom();
//		classroom.setClassName(name);
		
//		ClassSubject classSubject = new ClassSubject();
//		classSubject.setSubject(subject);
//		classSubject.setTeacher(teacher);		
//		classSubject.setClassroom(classroom);
		
//		Set<ClassSubject> classSubjects = classroom.getClassSubject();
//		classSubjects.add(classSubject);
//		
//		classroom.setClassSubject(classSubjects);
		
			
//		if (classId == null || classId == "")
//			classroomDao.saveClass(classroom);
//		else {
//			Long id = Long.parseLong(classId);
//			classroom.setClassId(id);
//			classroomDao.updateClassroom(classroom);
//		}
		
		listclasssubjects(request,response);

	}

	private void deleteClassSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		String id = request.getParameter("id");
		System.out.println("classId from delete class room  = "+ id);

		if (id == "" || id == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long classsubid = Long.parseLong(id);
			classsubjectDao.deleteClassSubject(classsubid);			
			System.out.println( "delete is done for ID"+classsubid);
		}
		
		listclasssubjects(request,response);
		
	}

	private void editClassSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long classsubId = Long.parseLong(request.getParameter("id"));
		System.out.println("class id from edit class   = "+ classsubId);
		
		ClassSubject existingClassSub = classsubjectDao.findClassSubjectById(classsubId);
		
		existingClassSub.setClassroom(classroomDao.findClassroomById(existingClassSub.getClassId()));
		existingClassSub.setSubject(subjectDao.findSubjectById(existingClassSub.getSubjectId()));
		existingClassSub.setTeacher(teacherDao.findTeacherById(existingClassSub.getTeacherId()));
	
		
		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
		
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		
		List<Teacher> teacherlist = teacherDao.findAllTeachers();
		request.setAttribute("teacherlist", teacherlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/classroomsubject-form.jsp");
		request.setAttribute("classsubject", existingClassSub);
		rd.forward(request, response);		
	}

	private void updateClassSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		String classsubId = request.getParameter("id");
		Long classId = Long.parseLong(request.getParameter("classId"));
		Long subjectId = Long.parseLong(request.getParameter("subjectId"));
		Long teacherId = Long.parseLong(request.getParameter("teacherId"));
	
		System.out.println("class idfrom updateclass  1  = "+ classsubId);
		if (classsubId == "" || classsubId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(classsubId);
			ClassSubject classSubject = new ClassSubject();
			classSubject.setId(id);
			classSubject.setClassId(classId);
			classSubject.setSubjectId(subjectId);
			classSubject.setTeacherId(teacherId);
			
			classsubjectDao.updateClassSubject(classSubject);
			
			listclasssubjects(request,response);
			
		}		
			
	}
	
	private void addclass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("add class ....");

		String classId = request.getParameter("id");
		String name = request.getParameter("class_name");		
		Classroom classroom = new Classroom();
		classroom.setClassName(name);
			
		if (classId == null || classId == "")
			classroomDao.saveClass(classroom);
		else {
			Long id = Long.parseLong(classId);
			classroom.setClassId(id);
			classroomDao.updateClassroom(classroom);
		}
		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
			
		System.out.println(classlist);
		
		request.getRequestDispatcher("/html/classroom.jsp").forward(request, response);
		
	}

	private void deleteclass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		System.out.println("classId from delete class room  = "+ classId);

		if (classId == "" || classId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(classId);
			//TeacherDao teacherDao = TeacherDaoImpl.getInstance();

			classroomDao.deleteClassroom(id);
			System.out.println( "delete is done for ID"+id);
		}
		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);	
	
		System.out.println(classlist);
		
		request.getRequestDispatcher("/html/classroom.jsp").forward(request, response);
		
	}

	private void updateclass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String classId = request.getParameter("classId");
		String name = request.getParameter("name");	
		
		System.out.println("class idfrom updateclass  1  = "+ classId);
		if (classId == "" || classId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(classId);
			System.out.println("updatesubject 2 id=" +id );
			Classroom classRoom = new Classroom();
			classRoom.setClassId(id);
			classRoom.setClassName(name);
			classroomDao.updateClassroom(classRoom);

			List<Classroom> classRooms = classroomDao.findAllClassrooms();
			System.out.println("list of class rooms " + classRooms);
			request.setAttribute("classlist", classRooms);
			request.getRequestDispatcher("/html/classroom.jsp").forward(request, response);
		}
		
	}

	private void editclass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Long classId = Long.parseLong(request.getParameter("classId"));
		System.out.println("class id from edit class   = "+ classId);
		Classroom existingClassroom = classroomDao.findClassroomById(classId);		
		RequestDispatcher rd = request.getRequestDispatcher("/html/classroom-form.jsp");
		request.setAttribute("classroom", existingClassroom);
		rd.forward(request, response);
		
	}

	private void listteacher (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<Teacher> teacherlist = teacherDao.findAllTeachers();
		request.setAttribute("teacherlist", teacherlist);
		
		System.out.println(teacherlist);
		List<Subject> teachersubjectlist = subjectDao.findAllSubjects();
		request.setAttribute("teachersubjectlist", teachersubjectlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/teacher.jsp");
		rd.forward(request, response);

	}
	
	private void liststudents (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<Student> studentlist = studentDao.findAllStudents();
		request.setAttribute("studentlist", studentlist);
		
		List<Classroom> classlist = classroomDao.findAllClassrooms();
		request.setAttribute("classlist", classlist);
		
		System.out.println(studentlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/student.jsp");
		rd.forward(request, response);

	}
	
	private void listsubject (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/subject.jsp");
		rd.forward(request, response);

	}
	
	private void listclasses (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
		
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		
		List<Teacher> teacherlist = teacherDao.findAllTeachers();
		request.setAttribute("teacherlist", teacherlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/classroom.jsp");
		rd.forward(request, response);
	}
	
	private void listteachersubject (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

			
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		
		List<Teacher> teacherlist = teacherDao.findAllTeachers();
		request.setAttribute("teacherlist", teacherlist);
		
		Map<Teacher,Set<Subject>> teacherSubjects = new HashMap<>();
		
		for(Teacher teacher : teacherlist) {
			Set<Subject> subjects = teacherDao.findSubjectByTeacher(teacher.getTeacherId());
			teacherSubjects.put(teacher,subjects);
		}
			
		request.setAttribute("teacherSubjects", teacherSubjects);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/teachersubject.jsp");
		rd.forward(request, response);
	}
	
	private void addteachersub (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {		
		
		Long teacherId = Long.parseLong(request.getParameter("teacherId"));
		String[] subjectsId = request.getParameterValues("subjects");
		
		Teacher teacher = teacherDao.findTeacherById(teacherId);
		Set<Subject> subjects = new HashSet<>();
		for(String id:subjectsId) {
			subjects.add(subjectDao.findSubjectById(Long.parseLong(id)));
		}
		
		teacherDao.addTeacherSubject(teacher, subjects);
		listteachersubject(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/html/teachersubject.jsp");
		rd.forward(request, response);
	}
	
	private void editteachersub (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {	
		Long teacherId = Long.parseLong(request.getParameter("id"));
		
		Teacher teacher = teacherDao.findTeacherById(teacherId);
		Set<Subject> teacherSubjects = teacherDao.findSubjectByTeacher(teacherId);
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		
		request.setAttribute("teacher", teacher);
		request.setAttribute("teacherSubjects", teacherSubjects);	
		request.setAttribute("subjectlist", subjectlist);
	
		RequestDispatcher rd = request.getRequestDispatcher("/html/teachersubject-form.jsp");
		rd.forward(request, response);
	}
	
	private void updateteachersub (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {	
		Long teacherId = Long.parseLong(request.getParameter("id"));
		String[] subjectsId = request.getParameterValues("subjects");
		
		Teacher teacher = teacherDao.findTeacherById(teacherId);
		Set<Subject> subjects = new HashSet<>();
		for(String id:subjectsId) {
			subjects.add(subjectDao.findSubjectById(Long.parseLong(id)));
		}
		
		teacherDao.updateTeacherSubject(teacher, subjects);
		listteachersubject(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/html/teachersubject.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteteachersub (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {	
		Long teacherId = Long.parseLong(request.getParameter("id"));
		Teacher teacher = teacherDao.findTeacherById(teacherId);
		teacherDao.deleteTeacherSubject(teacher);
		listteachersubject(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/html/teachersubject.jsp");
		rd.forward(request, response);
	}
	
	private void listclasssubjects (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<ClassSubject> classsublist = classsubjectDao.findAllClassSubjects() ;
		request.setAttribute("classsublist", classsublist);
		
		
//		List<Long> classSubIds = classsublist.stream().map(e->e.getId()).collect(Collectors.toList());
//		List<Long> classIds = classsublist.stream().map(e->e.getClassId()).collect(Collectors.toList());
//		List<Long> subjectIds = classsublist.stream().map(e->e.getSubjectId()).collect(Collectors.toList());
//		List<Long> teacherIds = classsublist.stream().map(e->e.getTeacherId()).collect(Collectors.toList());
		
		//List<Classroom> classNames = classIds.stream().map(e->classroomDao.findClassroomById(e.getClassId()).collect(Collectors.toList()));
		
		classsublist.forEach(e->{
			e.setClassroom(classroomDao.findClassroomById(e.getClassId()));
			e.setSubject(subjectDao.findSubjectById(e.getSubjectId()));
			e.setTeacher(teacherDao.findTeacherById(e.getTeacherId()));
		});
		
		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
		
		List<Subject> subjectlist = subjectDao.findAllSubjects();
		request.setAttribute("subjectlist", subjectlist);
		
		List<Teacher> teacherlist = teacherDao.findAllTeachers();
		request.setAttribute("teacherlist", teacherlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/classroomsubject.jsp");
		rd.forward(request, response);
	}
	
	private void classreport (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/classreport.jsp");
		rd.forward(request, response);
	}
	
	private void showreport (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		Long classId = Long.parseLong(request.getParameter("classId"));
		
		List<Subject> subjectlist = classsubjectDao.findAllSubjectsByCalssId(classId);
		List<Teacher> teacherlist = classsubjectDao.findAllTeachersByCalssId(classId);
		List<Student> studentlist = classsubjectDao.findAllStudentsByCalssId(classId);
		Classroom selectedClassroom = classroomDao.findClassroomById(classId);
		
		List<Classroom> classlist = classroomDao.findAllClassrooms() ;
		request.setAttribute("classlist", classlist);
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("teacherlist", teacherlist);
		request.setAttribute("studentlist", studentlist);
		request.setAttribute("selectedClassroom", selectedClassroom);
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/showreport.jsp");
		rd.forward(request, response);
	}
	
}
