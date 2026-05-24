package com.wipro.cms.entity;

public class Enrollment {
	private String enrollmentId;

	   private String studentId;

	   private String courseId;

	   private String semester;

	   private double feeAmount;

	   public Enrollment(String enrollmentId, String studentId, String courseId, String semester, double feeAmount) {

		this.enrollmentId = enrollmentId;

		this.studentId = studentId;

		this.courseId = courseId;

		this.semester = semester;

		this.feeAmount = feeAmount;

	   }

	   public String getEnrollmentId() {

		return enrollmentId;

	   }

	   public void setEnrollmentId(String enrollmentId) {

		this.enrollmentId = enrollmentId;

	   }

	   public String getStudentId() {

		return studentId;

	   }

	   public void setStudentId(String studentId) {

		this.studentId = studentId;

	   }

	   public String getCourseId() {

		return courseId;

	   }

	   public void setCourseId(String courseId) {

		this.courseId = courseId;

	   }

	   public String getSemester() {

		return semester;

	   }

	   public void setSemester(String semester) {

		this.semester = semester;

	   }

	   public double getFeeAmount() {

		return feeAmount;

	   }

	   public void setFeeAmount(double feeAmount) {

		this.feeAmount = feeAmount;

	   }

	   
}
