package com.wipro.cms.util;

public class InvalidStudentException extends Exception{
	public String toString() {
   	 return "Student does not exists in the registered student list";
   	 
    }
}
