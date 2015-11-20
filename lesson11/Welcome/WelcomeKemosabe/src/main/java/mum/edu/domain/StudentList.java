package mum.edu.domain;

public class StudentList {
		int studentCounter = 0;
//    	String currentStudent = "";
    	String [] students = {"Mary Ann","Bill","Md"};
    	
    	
		public int getStudentCounter() {
			return studentCounter;
		}
		public void setStudentCounter(int studentCounter) {
			this.studentCounter = studentCounter;
		}
		public String getCurrentStudent() {
			return students[studentCounter];
		}
 
		public String[] getStudents() {
			return students;
		}
		public void setStudents(String[] students) {
			this.students = students;
		}
    	
    	


}
