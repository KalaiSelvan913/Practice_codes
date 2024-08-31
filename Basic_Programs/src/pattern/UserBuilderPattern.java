package pattern;

public class UserBuilderPattern {

	//Mandatory Fields
	private final String firstName;
	private final String secondName;
	
	//Optional Fields
	private int age;
	private String address;
	private String phone;
	
	public UserBuilderPattern(Builder builder){
		this.firstName = builder.firstName;
		this.secondName = builder.secondName;
		this.age = builder.age; 
		this.address = builder.address;
		this.phone = builder.phone;
	}

	public String getFirstName() {return firstName;}

	public String getSecondName() {return secondName;}

	public int getAge() {return age;}

	public String getAddress() {return address;}

	public String getPhone() {return phone;}

	@Override
	public String toString() {
		return "UserBuilderPattern [firstName=" + firstName + ", secondName=" + secondName + ", age=" + age
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	public static class Builder{
		//Mandatory Fields
		private final String firstName;
		private final String secondName;
		
		//Optional Fields
		private int age;
		private String address;
		private String phone;
		
		public Builder (String firstName, String secondName) {
			this.firstName = firstName;
			this.secondName = secondName;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserBuilderPattern build() {
			return new UserBuilderPattern(this);
		}
	}
	
	
}
