package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

public class FileService {
	private String csvStudentFile1 = "course1.csv";
	private	String csvStudentFile2 = "course2.csv";
	private String csvStudentFile3 = "course3.csv";
	
	private Student[] students = new Student[101];

	public Student[] parseStudentDataFile(String fileName) {
		BufferedReader fileReader = null;
		int i = 0;
		String line = "";

		try {
			fileReader = new BufferedReader(new FileReader(fileName));
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
			System.out.println("There was a FileNotFound exception error" + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was some kind of IO exception error" + fileName);
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("There was an IO exception error" + fileName);
				e.printStackTrace();
			}
		}
		return students;
	}

	public void groupStudents() {
		BufferedWriter writer = null;

		Student[] course1Students = new Student[students.length];
		Student[] course2Students = new Student[students.length];
		Student[] course3Students = new Student[students.length];

		int course1Count = 0;
		int course2Count = 0;
		int course3Count = 0;
		for (Student student : students) {
			if (student != null) {
				if (student.getCourse().startsWith("COMPSCI")) {
					course1Students[course1Count] = student;
					course1Count++;
				} else if (student.getCourse().startsWith("APMTH")) {
					course2Students[course2Count] = student;
					course2Count++;
				} else if (student.getCourse().startsWith("STAT")) {
					course3Students[course3Count] = student;
					course3Count++;
				}
			}
		}
		System.out.println("Course 1 Students:");
		Arrays.sort(course1Students, 0, course1Count);
		for (int i = 0; i < course1Count; i++) {
			if (course1Students[i] != null) {
				System.out.println(course1Students[i]);
				try {
					writer = new BufferedWriter(new FileWriter(csvStudentFile1));
					writer.write("Student ID,Student Name,Course,Grade");
					writer.newLine();
					for (int v = 0; v < course1Count; v++) {
						if (course1Students[v] != null) {
							writer.write(course1Students[v].toString());
							writer.newLine();
						}
					}
				} catch (IOException e) {
					System.out.println("There was some kind of IO exception error with course1.csv");
					e.printStackTrace();
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							System.out.println("here was some kind of IO exception error");
							e.printStackTrace();
						}
					}
				}

			}
		}

		System.out.println("Course 2 Students:");
		Arrays.sort(course2Students, 0, course2Count);
		for (int i = 0; i < course2Count; i++) {
			if (course2Students[i] != null)
				if (course1Students[i] != null) {
					System.out.println(course1Students[i]);
					try {
						writer = new BufferedWriter(new FileWriter(csvStudentFile2));
						writer.write("Student ID,Student Name,Course,Grade");
						writer.newLine();
						for (int f = 0; f < course2Count; f++) {
							if (course1Students[f] != null) {
								writer.write(course2Students[f].toString());
								writer.newLine();
							}
						}
					} catch (IOException e) {
						System.out.println("There was some kind of IO exception error with course1.csv");
						e.printStackTrace();
					} finally {
						if (writer != null) {
							try {
								writer.close();
							} catch (IOException e) {
								System.out.println("here was some kind of IO exception error");
								e.printStackTrace();
							}
						}
					}

				}
		}

		System.out.println("Course 3 Students:");
		Arrays.sort(course3Students, 0, course3Count);
		for (int i = 0; i < course3Count; i++)
			if (course1Students[i] != null) {
				System.out.println(course3Students[i]);
				try {
					writer = new BufferedWriter(new FileWriter(csvStudentFile3));
					writer.write("Student ID,Student Name,Course,Grade");
					writer.newLine();
					for (int r = 0; r < course3Count; r++) {
						if (course3Students[r] != null) {
							writer.write(course3Students[r].toString());
							writer.newLine();
						}
					}
				} catch (IOException e) {
					System.out.println("There was some kind of IO exception error with course1.csv");
					e.printStackTrace();
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							System.out.println("here was some kind of IO exception error");
							e.printStackTrace();
						}
					}
				}

			}
	}

}
