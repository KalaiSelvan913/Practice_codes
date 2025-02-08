package excercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBuilderLombok {
	private String name;
	private int age;
	private String department;
	
	@Override
	public String toString() {
		return "EmployeeBuilderLombok [name=" + name + ", age=" + age + ", department=" + department + "]";
	}
	
	
}

class LombokBuilderObjectCall{
	public static void main(String[] args) {
		EmployeeBuilderLombok empLombok = EmployeeBuilderLombok.builder().name("Kalai")
				.age(25).department("RS").build();
		System.out.println(empLombok);
	}
}
