
public class Lecturer extends StakeHolder{
	private int salary;
	private int classes;
	private String faculty;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getClasses() {
		return classes;
	}
	public void setClasses(int classes) {
		this.classes = classes;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecturer(String id, String name, int age, String role, int salary, int classes, String faculty) {
		super(id, name, age, role);
		this.salary = salary;
		this.classes = classes;
		this.faculty = faculty;
	}
	
	@Override
	public void showData() {
		System.out.printf("%-5s %-45s %-10s\n", this.id, this.name, this.role);
	}
	
	@Override
	public void showDataOwn() {
		System.out.printf("%-20s : %d\n", "Salary", this.salary);
		System.out.printf("%-20s : %d\n", "Total Class", this.classes);
		System.out.printf("%-20s : %s\n", "Faculty", this.faculty);
	}
}
