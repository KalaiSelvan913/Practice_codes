package StaticFactoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContex {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("TestBean.xml");
		Airtel a = (Airtel)context.getBean("test");
		a.call();
	}

}
