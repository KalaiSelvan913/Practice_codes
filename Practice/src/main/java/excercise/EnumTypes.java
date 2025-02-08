package excercise;

public class EnumTypes {
	
	public enum NotificationType{
		SMS_TYPE("SMS"),
		EMAIL_TYPE("EMAIL"),
		PUSH_TYPE("PUSH");
		
		private final String name;
//		
		private NotificationType(String s){
			this.name = s;
		}
		
		public String toString() {
			return this.name;
		}
		}

}
