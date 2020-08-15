package POJO;

public class Student {
	private int id;
	private int studentID;
	private String name;

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentID=" + studentID + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
