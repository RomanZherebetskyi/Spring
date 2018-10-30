package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
//        while (true) {
//            Thread.sleep(1000);
//            classPathXmlApplicationContext.getBean(Quotable.class).sayQuote();
//        }
        classPathXmlApplicationContext.getBean(Quotable.class).sayQuote();
    }
}
