import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<StakeHolder> stake = new Vector<>();
	
	private int readInt() {
		int rt = 0;
		try {
			rt = scan.nextInt();
		} catch (Exception e) {
			rt = -1;
		}finally {
			scan.nextLine();
		}
		return rt;
	}
	
	private void addData() {
		String role = "";
		String name = "";
		int age = 0;
		String id = "";
		int salary = 0;
		int classes = 0;
		String faculty = "";
		double gpa = 0;
		String major = "";
	
		do {
			System.out.print("input your role [Lecturer | Student]: ");
			role = scan.nextLine();
		} while (role.compareTo("Lecturer") != 0 && role.compareTo("Student") != 0);
		
		do {
			System.out.print("Input your name [5..50]: ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 50);
		
		do {
			System.out.print("Input age [18..50]: ");
			age = readInt();
		} while (age < 18 || age > 50);
		
		if(role.compareTo("Lecturer") == 0) {
			do {
				System.out.print("Input Salary [5000000..50000000]: ");
				salary = readInt();
			} while (salary < 5000000 || salary > 50000000);
			
			do {
				System.out.print("Input class [1..5]: ");
				classes = readInt();
			} while (classes < 1 || classes > 5);
			
			do {
				System.out.print("Faculty [Computer Science | Design | Accounting] : ");
				faculty = scan.nextLine();
			} while (faculty.compareTo("Computer Science") != 0 && faculty.compareTo("Design") != 0 && faculty.compareTo("Accounting") != 0);
			id = StakeHolder.generateIdLecturer(stake.size() + 1);
			stake.add(new Lecturer(id, name, age, role, salary, classes, faculty));
			
			
		}else if(role.compareTo("Student") == 0){
			do {
				System.out.print("GPA [1..4]: ");
				gpa = scan.nextDouble();
			} while (gpa < 1 || gpa > 4);
			scan.nextLine();
			
			do {
				System.out.print("Major [Mobile Technology | Cyber Security | Game Technology] : ");
				major = scan.nextLine();
			} while (major.compareTo("Mobile Technology") != 0 && major.compareTo("Cyber Security") != 0 && major.compareTo("Game Technology") != 0);
			id = StakeHolder.generateIdStudent(stake.size() + 1);
			stake.add(new Student(id, name, age, role, gpa, major));
		}
		
	}
	
	private void updateData() {
		viewData();
		int edit = 0;
		do {
			System.out.printf("Update Number : [1..%d] : ", stake.size());
			edit = readInt();
		} while (edit < 1 || edit > stake.size());
		
		String name = "";
		int age = 0;
		String id = "";
		int salary = 0;
		int classes = 0;
		String faculty = "";
		double gpa = 0;
		String major = "";

		do {
			System.out.print("Input your name [5..50]: ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 50);
		
		do {
			System.out.print("Input age [18..50]: ");
			age = readInt();
		} while (age < 18 || age > 50);
		
		if(stake.get(edit - 1).getRole().compareTo("Lecturer") == 0) {
			do {
				System.out.print("Input Salary [5000000..50000000]: ");
				salary = readInt();
			} while (salary < 5000000 || salary > 50000000);
			
			do {
				System.out.print("Input class [1..5]: ");
				classes = readInt();
			} while (classes < 1 || classes > 5);
			
			do {
				System.out.print("Faculty [Computer Science | Design | Accounting] : ");
				faculty = scan.nextLine();
			} while (faculty.compareTo("Computer Science") != 0 && faculty.compareTo("Design") != 0 && faculty.compareTo("Accounting") != 0);
			stake.set(edit - 1, new Lecturer(id, name, age, "Lecturer", salary, classes, faculty));
			
		}else if(stake.get(edit - 1).getRole().compareTo("Student") == 0) {
			do {
				System.out.print("GPA [1..4]: ");
				gpa = scan.nextDouble();
			} while (gpa < 1 || gpa > 4);
			scan.nextLine();
			
			do {
				System.out.print("Major [Mobile Technology | Cyber Security | Game Technology] : ");
				major = scan.nextLine();
			} while (major.compareTo("Mobile Technology") != 0 && major.compareTo("Cyber Security") != 0 && major.compareTo("Game Technology") != 0);
			stake.set(edit - 1, new Student(id, name, age, "Student", gpa, major));
		}
	}
	
	private void viewData() {
		int i = 0;
		System.out.printf("%-5s %-5s %-45s %-10s\n", "No", "ID", "Name", "Role");
		for (StakeHolder stakeHolder : stake) {
			System.out.printf("%-5d ", ++i);
			stakeHolder.showData();
		}
	}
	
	int k = 0;
	private boolean validateId(String viewId) {
		k = 0;
		for (int i = 0; i < stake.size(); i++) {
			if(viewId.compareTo(stake.get(i).getId()) == 0) {
				k = i;
				return true;
			}
		}
		return false;
	}
	
	private void detailsData() {
		String viewId = "";
		do {
			System.out.print("ID to view detail : ");
			viewId = scan.nextLine();
		} while (validateId(viewId) == false);
		
		System.out.printf("%-20s : %s\n", "ID", stake.get(k).getId());
		System.out.printf("%-20s : %s\n", "Name", stake.get(k).getName());
		stake.get(k).showDataOwn();
		scan.nextLine();
	}
	
	private void exit() {
		stake.clear();
	}
	public Main() {
		int choose = 0;
		int edit = 0;
		do {
			System.out.println("1. Add Stakeholder");
			System.out.println("2. Update Stakeholder");
			System.out.println("3. View Summary");
			System.out.println("4. View Detail");
			System.out.println("5. Exit");
			System.out.print("Choose [1..5] : ");
			choose = readInt();
			switch (choose) {
			case 1:
				addData();
				break;
				
			case 2: updateData(); break;
			
			case 3: viewData(); scan.nextLine(); break;
			
			case 4: detailsData(); break;
			
			default:
				break;
			}
			
		}while(choose != 5);
		exit();
	}

	public static void main(String[] args) {
		new Main();
	}

}
