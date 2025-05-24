package training;

import java.math.BigDecimal;

public class ParseJson {
	public static void main(String[] args) {
		
		 DynamicPojo pojo = new DynamicPojo();

	        // Dynamically setting values with different types
	        pojo.setName("John Doe");                             // String
	        pojo.setAge(30);                                      // Integer
	        pojo.setIsActive(true);                               // Boolean
	        pojo.setSalary(new BigDecimal("2500.75"));            // BigDecimal
	        pojo.setTimestamp(System.currentTimeMillis());        // Long
	        
		
	}
}

class DynamicPojo {
    private Object name;
    private Object age;
    private Object isActive;
    private Object salary;
    private Object timestamp;
    
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getAge() {
		return age;
	}
	public void setAge(Object age) {
		this.age = age;
	}
	public Object getIsActive() {
		return isActive;
	}
	public void setIsActive(Object isActive) {
		this.isActive = isActive;
	}
	public Object getSalary() {
		return salary;
	}
	public void setSalary(Object salary) {
		this.salary = salary;
	}
	public Object getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Object timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "DynamicPojo [name=" + name + ", age=" + age + ", isActive=" + isActive + ", salary=" + salary
				+ ", timestamp=" + timestamp + "]";
	}
    
	
    
}
