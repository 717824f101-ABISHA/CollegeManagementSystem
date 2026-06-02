package com.wipro.cms.entity;

public class Course {
	private String courseId;

	private String title;

	private int credits;

	private int maxCapacity;

	private int  enrolledCount;

	public Course(String courseId, String title, int credits, int maxCapacity, int enrolledCount) {

		super();

		this.courseId = courseId;

		this.title = title;

		this.credits = credits;

		this.maxCapacity = maxCapacity;

		this.enrolledCount = enrolledCount;

	}

	public String getCourseId() {

		return courseId;

	}

	public void setCourseId(String courseId) {

		this.courseId = courseId;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public int getCredits() {

		return credits;

	}

	public void setCredits(int credits) {

		this.credits = credits;

	}

	public int getMaxCapacity() {

		return maxCapacity;

	}

	public void setMaxCapacity(int maxCapacity) {

		this.maxCapacity = maxCapacity;

	}

	public int getEnrolledCount() {

		return enrolledCount;

	}

	public void setEnrolledCount(int enrolledCount) {

		this.enrolledCount = enrolledCount;

	}
}
