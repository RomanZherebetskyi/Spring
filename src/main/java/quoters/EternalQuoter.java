package quoters;

public class EternalQuoter implements Quotable {

    @Override
    public void sayQuote() {
        System.out.println("Eternal quote: rock'n'roll!");
    }
}
