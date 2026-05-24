package com.wipro.cms.util;

public class CourseFullException extends Exception{
         public String toString() {
        	 return "CourseCapacityFullException: Course has reached its maximum allowed capacity No more students can be enrolled.";
         }
}
