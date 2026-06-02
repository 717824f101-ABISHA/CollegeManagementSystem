package com.wipro.cms.util;
import java.lang.Exception;
public class EnrollmentException extends Exception {
	private static final long serialVersionUID = 1L;
		 private String message;
	public EnrollmentException(String message) {
	     this.message=message;
	}
	public String toString() {
	   if(message.equals("enrollmentId")) {
		return "Invalid enrollmentId!!!ID doesn't exists";
	   }
	   else if(message.equals("Course")) {
		   return "Invalid Course!";
	   }
	   else if(message.equals("duplicate")) {
		   return "Enrollment ID already exists!";
	   }
	   return "";
    }
}
