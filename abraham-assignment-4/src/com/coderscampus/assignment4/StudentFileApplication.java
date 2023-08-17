package com.coderscampus.assignment4;

public class StudentFileApplication {

	public static void main(String[] args) {
		FileService studentFileService = new FileService();
		studentFileService.parseStudentDataFile("student-master-list.csv");
		studentFileService.groupStudents();
		
	}
	
	
}
