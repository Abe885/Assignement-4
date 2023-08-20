package com.coderscampus.assignment4;

public class Student implements Comparable<Student> {

	private String studentID;
	private String name;
	private String course;
	private String grade;

	public Student(String studentID, String name, String course, String grade) {
		this.studentID = studentID;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public int compareTo(Student that) {
		if (this.grade.compareTo(that.grade) == 0) {
			return this.name.compareTo(that.name);
		} else {
			return that.grade.compareTo(this.grade);
		}

	}

	public String toString() {
		return studentID + "," + name + "," + course + ","
				+  grade;
	}
}
