
public class StakeHolder {
	protected String id;
	protected String name;
	protected int age;
	protected String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public StakeHolder() {};
	public StakeHolder(String id, String name, int age, String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
	}
	public static String generateIdLecturer(int many) {
		String idTemp = "";
		char []temp = new char[4];
		temp[0] = 'L';
		
		if(many < 10) {
			for(int i = 1; i < temp.length; i++) {
				temp[i] = '0';
			}
			String s = String.valueOf(many);
			temp[3] = s.charAt(0);
			
		}else if(many >= 10 && many < 100) {
			for(int i = 0; i < temp.length - 1; i++) {
				temp[i] = '0';
			}
			String s = String.valueOf(many);
			temp[2] = s.charAt(0);
			temp[3] = s.charAt(1);
			
		}else {
			String s = String.valueOf(many);
			temp[1] = s.charAt(0);
			temp[2] = s.charAt(1);
			temp[3] = s.charAt(2);
		}
		idTemp = String.valueOf(temp);
		return idTemp;
	}
	
	public static String generateIdStudent(int many) {
		String idTemp = "";
		char []temp = new char[4];
		temp[0] = 'S';
		
		if(many < 10) {
			for(int i = 1; i < temp.length; i++) {
				temp[i] = '0';
			}
			String s = String.valueOf(many);
			temp[3] = s.charAt(0);
			
		}else if(many >= 10 && many < 100) {
			for(int i = 0; i < temp.length - 1; i++) {
				temp[i] = '0';
			}
			String s = String.valueOf(many);
			temp[2] = s.charAt(0);
			temp[3] = s.charAt(1);
			
		}else {
			String s = String.valueOf(many);
			temp[1] = s.charAt(0);
			temp[2] = s.charAt(1);
			temp[3] = s.charAt(2);
		}
		idTemp = String.valueOf(temp);
		return idTemp;
	}
	public void showData() {
		// TODO Auto-generated method stub

	}
	
	public void showDataOwn() {
		// TODO Auto-generated method stub

	}
}
