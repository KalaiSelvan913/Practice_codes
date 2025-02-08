import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class Man1Main {

	public static void main(String[] args) {
		
BeanFactory bf = new XmlBeanFactory(new ClassPathResource("Man1.xml"));
		
		Man1 m = (Man1)bf.getBean("man1");
		System.out.println(m.getName()+" "+m.getAge()+" "+m.getLocation());
		System.out.println(m);
		
		//This is Bean Scope method Prototype 
		Man1 m2=(Man1)bf.getBean("man1");
		System.out.println(m2);

	}

}
