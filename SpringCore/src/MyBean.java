import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyBean {
	private String myName;
	private String password;

	public static void main(String[] args) {
		
		BeanFactory bf = new ClassPathXmlApplicationContext("mybean.xml");
		MyBean bean = (MyBean)bf.getBean("mBean");
		System.out.println(bean.getMyName());
		System.out.println(bean.getpassword());
		
		
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
