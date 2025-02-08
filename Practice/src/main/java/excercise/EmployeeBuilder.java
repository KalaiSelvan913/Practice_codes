package excercise;

public class EmployeeBuilder {
	private String name;
	private int age;
	private String department;
	
	private EmployeeBuilder(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.department = builder.department;
	}
	
	EmployeeBuilder(){}
	
	
	
	
	@Override
	public String toString() {
		return "EmployeeBuilder [name=" + name + ", age=" + age + ", department=" + department + "]";
	}




	public static class Builder {
		private String name;
		private int age;
		private String department;
		
		public static Builder getInstance() {
			return new Builder();
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder setDepartment(String department) {
			this.department = department;
			return this;
		}
		
		public EmployeeBuilder build() {
			return new EmployeeBuilder(this);
		}
	}



}





class builderObject{
	public static void main(String[] args) {
		
//		entity = repo.findByID();
		EmployeeBuilder emp = EmployeeBuilder.Builder.getInstance().setName("Kalai").setAge(25).setDepartment("RS").build();
//		EmployeeBuilder emp = new EmployeeBuilder();
//		emp.setName(entity.getName());
//		emp.setAge();
		System.out.println(emp);
	}
}

