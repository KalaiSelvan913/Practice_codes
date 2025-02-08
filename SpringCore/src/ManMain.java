import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class ManMain {
	public static void main(String args[]){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("Man.xml"));
		
		Man m = (Man)bf.getBean("man");
		System.out.println(m.getName()+" "+m.getAge()+" "+m.getLocation());
		System.out.println(m);
		
		Man m1 = (Man)bf.getBean("man");
		System.out.println(m1); //this is Scope method in Bean(Singleton)
		
		
	}

}
