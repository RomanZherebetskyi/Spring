package quoters;

public class TerminatorQuoter implements Quotable {

    static {
        System.out.println("Static print");
    }

    {
        System.out.println("Non-static print");
    }

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;


    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(repeat);
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

}
