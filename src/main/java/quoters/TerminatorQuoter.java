package quoters;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quotable, InitializingBean {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Constructor..., repeat = " + repeat + ", message - " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method... , repeat = " + repeat + ", message - " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet (InitializingBean) method..., repeat = " + repeat + ", message - " + message);

    }
}
