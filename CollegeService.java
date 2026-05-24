package com.wipro.cms.service;
import java.util.*;
import com.wipro.cms.entity.Student;
import com.wipro.cms.util.InvalidStudentException;
import com.wipro.cms.util.CourseFullException;
import com.wipro.cms.util.EnrollmentException;
import com.wipro.cms.entity.Course;
import com.wipro.cms.entity.Enrollment;
public class CollegeService {
  private ArrayList<Student> students=new ArrayList<>();
  private ArrayList<Course> courses = new ArrayList<>();
  private ArrayList<Enrollment> enrollments = new ArrayList<>();
  public CollegeService(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Enrollment> enrollments) {
	super();
	this.students = students;
	this.courses = courses;
	this.enrollments = enrollments;
  }
  public boolean validateStudent(String studentId) throws InvalidStudentException{
	            for(Student s:students) {
	            	if(s.getStudentId()==studentId)
	            		return true;
	            }
	            	  throw new InvalidStudentException();
  }
  public boolean validateCourse(String courseId) throws EnrollmentException{
	  for(Course c:courses) {
      	if(c.getCourseId()==courseId)
      		return true;
      }
    	  throw new EnrollmentException("Course");
  }
  public boolean checkCourseCapacity(String courseId)throws CourseFullException,EnrollmentException{
	                 boolean flag=false;
	                 Course course=null;
	                 for(Course c:courses) {
	                	     if(c.getCourseId()==courseId) {
	                	    	  course=c;
	                	    	 flag=true;
	                	     }
	                 }
	                 if(flag==false)
	                	 throw new EnrollmentException("Course");
	                 if(course.getMaxCapacity()<course.getEnrolledCount()+1) {
	                	 throw new CourseFullException();
	                 }
	                 return true;
  }
  public Enrollment enrollStudent(String enrollmentId,String studentId, String courseId, String semester) throws Exception{
	                 validateStudent(studentId);
	                 validateCourse(courseId);
	                 checkCourseCapacity(courseId);
	                 for(Enrollment e:enrollments) {
	                	 if(e.getEnrollmentId()==enrollmentId)
	                		 throw new EnrollmentException("duplicate");
	                 }
	                 Enrollment en=new Enrollment(enrollmentId,studentId,courseId,semester,calculateFee(courseId));
	                 enrollments.add(en);
	                 for(Course c:courses) {
                	     if(c.getCourseId()==courseId) {
                	    	  c.setEnrolledCount(c.getEnrolledCount()+1);
                	     }
                 }
	            for(Student s:students) {
                	     if(s.getStudentId()==studentId) {
                	    	 for(Course c:courses) {
                        	     if(c.getCourseId()==courseId) 
                        	    	  s.setCurrentCredits(s.getCurrentCredits()+c.getCredits());
                        	  }
                	     }
                 }
	            return en;
  }
  public boolean dropEnrollment(String enrollmentId) throws EnrollmentException{
	  for(Enrollment e:enrollments) {
     	 if(e.getEnrollmentId()==enrollmentId) {
     		  enrollments.remove(e);
     	for(Course c:courses) {
   	     if(c.getCourseId()==e.getCourseId()) 
   	    	  c.setEnrolledCount(c.getEnrolledCount()-1);
     }
     	return true;
      }
    }
	  throw new EnrollmentException("enrollmentId");
  }
  public double calculateFee(String courseId) {
	  for(Course c:courses) {
 	     if(c.getCourseId()==courseId) 
 	    	  return c.getCredits()*1000.0;
  }
	  return 0;
 }
  public void printStudentEnrollments(String studentId) {
	  for(Student s: students) {
		  if(s.getStudentId()==studentId) {
			  System.out.println("Student ID : "+studentId+"\n Student Name : "+s.getName()+"\nProgram : "+s.getProgram()+"\nCurrent Credits : "+s.getCurrentCredits());
		       break;
		  }
	  }
	  System.out.println("Courses Enrolled:-");
	    for(Enrollment e: enrollments) {
	    	if(e.getStudentId()==studentId) {
	    		System.out.println("Enrollment ID: "+e.getEnrollmentId()+"\nCourse ID:"+e.getCourseId());
	    		for(Course c:courses) {
	    	 	     if(c.getCourseId()==e.getCourseId()) {
	    	 	    	 System.out.println("Course Name : "+c.getTitle());
	    	 	          break;
	    	 	     }
	    	    }
	    	}
	    	System.out.println("=============================================");
	    }
  }
}
