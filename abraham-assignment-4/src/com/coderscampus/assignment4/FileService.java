package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

public class FileService {
	private Student[] students = new Student[101];

	public Student[] parseStudentData() {
		BufferedReader fileReader = null;
		BufferedWriter fileWriter = null;
		int i = 0;
		String line = "";

		try {
			fileReader = new BufferedReader(new FileReader("student-master-list.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] studentData = line.split(",");

				if (studentData.length == 4) {
					String studentID = studentData[0];
					String name = studentData[1];
					String course = studentData[2];
					String grade = studentData[3];
					students[i] = new Student(studentID, name, course, grade);
					i++;
				}
			}
			for (int x = 0; x < students.length; x++) {
				System.out.println("Elements " + x + " is " + students[x]);
		
			}

		} catch (FileNotFoundException e) {
			System.out.println("There was a FileNotFound exception error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was some kind of IO exception error");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("There was an IO exception error");
				e.printStackTrace();
			}
		}
		return students;
	}

}

//		String course = student.getCourse();
//if (course.matches("COMPSCI+[0-9]{3}")) {
// writer = new BufferedWriter(new FileWriter("course1.csv"));

//public void masterFileSeperation(Student[] students){
//BufferedWriter writer = null;
//
//try { 
//	writer = new BufferedWriter(new FileWriter("course1.csv"));
//	
//	for(int i = 0; i < 102; i++) {
//		Student student = students[i];
//		
//		String studentID = student.getStudentID();
//		String name = student.getName();
//		String course = student.getCourse();
//		String grade = student.getGrade();
//		
//		String csvLine = studentID + "," + name + "," + course + "," + grade;
//		
//	
//	}
//	
//} catch (IOException e) {
//	e.printStackTrace();
//}
//}
