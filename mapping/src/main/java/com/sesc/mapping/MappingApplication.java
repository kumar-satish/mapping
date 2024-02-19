package com.sesc.mapping;

import com.sesc.mapping.models.Address;
import com.sesc.mapping.models.Department;
import com.sesc.mapping.models.Projects;
import com.sesc.mapping.models.Student;
import com.sesc.mapping.repositories.DepartmentRepository;
import com.sesc.mapping.repositories.ProjectRepository;
import com.sesc.mapping.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MappingApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private ProjectRepository projectRepository;
	private Logger logger = LoggerFactory.getLogger(MappingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);}

		@Override
		public void run(String... args) throws Exception {

/***
 *   -------------ONE TO ONE MAPPING --------------
 * One to one mapping between Student class and Address class.
 * To create and store record into database table with following mapping.
 *
  */


		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("Alex");
		student.setStudentCourse("MSc");

		Address address = new Address();
		address.setHouseNumber(201);
		address.setStreetName("Leeds Road");
		address.setPostCode("XY34CZ");
		address.setCountryName("UK");
		address.setStudent(student);

		student.setAddress(address);

		Student save = studentRepository.save(student);

		logger.info("saved student : {}", save.getStudentName());



			/***
			 * To access student name and address through student id. Here, we can see that the
			 * student id property maintained the relationship and there is no need to use address id
			 * to get student address.
			 */

			/*
			Student student = studentRepository.findById(101).get();
			logger.info("student name is {}", student.getStudentName());

			Address address = student.getAddress();
			logger.info("student address is {}, {}, {}, {}", address.getHouseNumber(), address.getStreetName(),address.getPostCode(), address.getCountryName());
			*/


/***
 * -------------------ONE TO MANY MAPPING
 * One to many (or many to one) mapping between Department class and Student class.
 * To create and store records into database table with following mapping.
  */


/*			Department dept = new Department();
			dept.setDeptId(301);
			dept.setDeptName("Computer Science");

			Student student1 = new Student();
			student1.setStudentId(101);
			student1.setStudentName("Bob");
			student1.setStudentCourse("MSc");
			student1.setDepartment(dept);

			Student student2 = new Student();
			student2.setStudentId(102);
			student2.setStudentName("Alice");
			student2.setStudentCourse("MSc");
			student2.setDepartment(dept);

			List<Student> studentList = new ArrayList<>();
			studentList.add(student1);
			studentList.add(student2);

			dept.setStudents(studentList);

			Department save = departmentRepository.save(dept);
			logger.info("Students are created with department");

*/


/***
 * To access department name and associated list of students through department id. Here, we can see that the
 * department id property maintained the relationship and there is no need to use student id
 * to get student details.
 */

/*			Department department = departmentRepository.findById(301).get();
			logger.info("Department Name : {}", department.getDeptName());

			List<Student> stdList = department.getStudents();
			for (Student s:stdList) {
				logger.info("student {},{},{}", s.getStudentId(),s.getStudentName(),s.getStudentCourse());
			}
*/


/***
 * -------------------MANY TO MANY MAPPING
 * Many to many mapping between Project class and Student class.
 * To create and store records into database table with following mapping.
 */


/*
			Student student1 = new Student();
			student1.setStudentId(104);
			student1.setStudentName("Tom");
			student1.setStudentCourse("MSc");

			Student student2 = new Student();
			student2.setStudentId(105);
			student2.setStudentName("Nisa");
			student2.setStudentCourse("MSc");

			Student student3 = new Student();
			student3.setStudentId(106);
			student3.setStudentName("James");
			student3.setStudentCourse("MSc");

			Student student4 = new Student();
			student4.setStudentId(107);
			student4.setStudentName("Alex");
			student4.setStudentCourse("MSc");

			Projects projects1 = new Projects();
			projects1.setProjectId(501);
			projects1.setProjectName("ABC Banking Software");
			projects1.setProjectDomain("Financial Domain");

			Projects projects2 = new Projects();
			projects2.setProjectId(502);
			projects2.setProjectName("XYZ Medical Software");
			projects2.setProjectDomain("Healthcare Domain");


			List<Student> projects1Students = projects1.getStudents();
			projects1Students.add(student1);
			projects1Students.add(student2);

			List<Student> projects2Students = projects2.getStudents();
			projects2Students.add(student1);
			projects2Students.add(student2);
			projects2Students.add(student3);
			projects2Students.add(student4);

			projectRepository.save(projects1);
			projectRepository.save(projects2);

*/


/***
 * To access project name and associated list of students through project id. Here, we can see that the
 * project id property maintained the relationship and there is no need to use student id
 * to get student details.
 */

/*			Projects projects = projectRepository.findById(502).get();
			logger.info("Project Name : {}", projects.getProjectName());

			List<Student> stdList = projects.getStudents();
			for (Student s:stdList) {
				logger.info("student {},{},{}", s.getStudentId(),s.getStudentName(),s.getStudentCourse());
			}
*/


		}


}
