package reflection;

public class Student {
	private int age;
	final public String firstNameString = "Test"; 
	public String lastNameString;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastNameString() {
		return lastNameString;
	}
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}
	public String getFirstNameString() {
		return firstNameString;
	}
	
	public Student(int age, String lastNameString) {
		this.age = age;
		this.lastNameString = lastNameString;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", firstNameString=" + firstNameString + ", lastNameString=" + lastNameString
				+ "]";
	}	
}
