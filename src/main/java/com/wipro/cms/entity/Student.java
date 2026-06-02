package com.wipro.cms.entity;

public class Student {
	private String studentId;
	private String name;
	private String program;
	private int currentCredits;
	
	public Student(String studentId, String name, String program, int currentCredits) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.program = program;
		this.currentCredits = currentCredits;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getCurrentCredits() {
		return currentCredits;
	}
	public void setCurrentCredits(int currentCredits) {
		this.currentCredits = currentCredits;
	}
	
}
