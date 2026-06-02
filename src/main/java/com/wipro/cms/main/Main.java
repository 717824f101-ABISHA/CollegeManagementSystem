package com.wipro.cms.main;

import java.util.ArrayList;
import com.wipro.cms.entity.Student;
import com.wipro.cms.entity.Course;
import com.wipro.cms.entity.Enrollment;
import com.wipro.cms.service.CollegeService;
import com.wipro.cms.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("S001", "Rahul Sharma", "BSc CS", 0));
		students.add(new Student("S002", "Ananya Rao", "BCom General", 0));
		ArrayList<Course> courses = new ArrayList<>();
		courses.add(new Course("CO101", "Data Structures", 4, 2, 0));
		courses.add(new Course("CO102", "Operating Systems", 3, 1, 0));
		ArrayList<Enrollment> enrollments = new ArrayList<>();
		CollegeService service = new CollegeService(students, courses, enrollments);
		try {
			service.validateStudent("S001");
			service.validateCourse("CO101");
			service.checkCourseCapacity("CO101");
			Enrollment en = service.enrollStudent("E101", "S001", "CO101", "SEM1");
			System.out.println("Enrollment Successful!");
			System.out.println("Enrollment ID: " + en.getEnrollmentId());
			System.out.println("Course ID : " + en.getCourseId());
			System.out.println("Fee Amount : Rs." + en.getFeeAmount());
			System.out.println("\n--- Student Enrollment Summary ---");
			service.printStudentEnrollments("S001");
		} catch (InvalidStudentException ise) {
			System.out.println(ise.toString());
		} catch (CourseFullException cfe) {
			System.out.println(cfe.toString());
		} catch (EnrollmentException ee) {
			System.out.println(ee.toString());
		} catch (Exception ex) {
			System.out.println("Unexpected Error: " + ex.toString());
		}
	}
}
