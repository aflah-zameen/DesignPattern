interface Notification{
    void alertUser();
}

class EmailNotification implements Notification{
    @Override
    public void alertUser(){
        System.out.println("Email : ALERT");
    }
}
class SMSNotification implements Notification{
    @Override
    public void alertUser(){
        System.out.println("SMS : ALERT");
    }
}

interface NotificationCreator{
    Notification getNotificationObject();
}
class SMSNotificationCreator implements NotificationCreator{
    @Override
    public Notification getNotificationObject(){
        return new SMSNotification();
    }
}
class EmailNotificationCreator implements NotificationCreator{
    @Override
    public Notification getNotificationObject(){
        return new EmailNotification();
    }
}

public class NotificationApplication {
    public static void main(String [] args){
        NotificationCreator creator = new EmailNotificationCreator();
        Notification notification = creator.getNotificationObject();
        notification.alertUser();

    }
}
