package excercise;

import excercise.EnumTypes.NotificationType;

interface Notification{
	void notifyUser();
}

public class FactoryPattern {
	
}

class SmsNotification implements Notification {
	@Override
	public void notifyUser() {
		System.out.println("Sending SMS Notification..");
	}
}

class EmailNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("Sending Email Notification..");
	}
}

class PushNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("Sending Push Notification..");
	}
}



class NotificationFactory{
	public Notification getNotification(NotificationType type) {
		if(type == null )
			return null;
		
		switch(type) {
		case SMS_TYPE:
			return new SmsNotification();
		case EMAIL_TYPE:
			return new EmailNotification();
		case PUSH_TYPE:
			return new PushNotification();
		default:
			throw new IllegalArgumentException("Unknown Channel "+type);
		}
	}
}

class notificationService{
	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.getNotification(NotificationType.PUSH_TYPE);
		System.out.println(NotificationType.PUSH_TYPE.toString()+" value is of type "+((Object)NotificationType.PUSH_TYPE.toString()).getClass().getSimpleName());
		notification.notifyUser();
		System.out.println("PUSH".equals(NotificationType.PUSH_TYPE.toString()));
	}
}
