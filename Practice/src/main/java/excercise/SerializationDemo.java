package excercise;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;



class Address{
	String addressLine,city,state;
	Address(String addressLine, String city, String state){
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
	}
}

class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String name;
	int age;
	Address address;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}



public class SerializationDemo {

	public static void main(String[] args) {

		Student std = new Student("Kalai", 20);
//		Student std1 = new Student("Selvan", 25);
		serializingObject(std);
		deSerializingObject();

	}

	private static void serializingObject(Student std) {
		try {
			FileOutputStream file = new FileOutputStream("AnotherSample.txt");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(std);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deSerializingObject(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AnotherSample.txt"));
			Student s = (Student)ois.readObject();
			System.out.println("name : "+s.name+", age : "+s.age);
			ois.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
