import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;




public class Phone {

	public static void main(String arg[]){
	
		Resource res = new ClassPathResource("SpringDemoxml.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		Airtel air = (Airtel)bf.getBean("a");
		air.call();
		air.Data();
		air.Sms();
		Jio j = (Jio)bf.getBean("j");
		j.call();
		j.Data();
		j.Sms();
	}
}
