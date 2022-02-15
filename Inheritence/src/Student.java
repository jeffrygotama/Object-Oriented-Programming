
public class Student extends StakeHolder{
	private double gpa;
	private String major;
	public double getGpa() {
		return gpa;
	}
	public void setGpa(int gpa) {
		this.gpa = gpa;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name, int age, String role, double gpa, String major) {
		super(id, name, age, role);
		this.gpa = gpa;
		this.major = major;
	}
	
	@Override
	public void showData() {
		System.out.printf("%-5s %-45s %-10s\n", this.id, this.name, this.role);
	}
	
	@Override
	public void showDataOwn() {
		System.out.printf("%-20s : %f\n", "GPA", this.gpa);
		System.out.printf("%-20s : %s\n", "Major", this.major);
	}
}
