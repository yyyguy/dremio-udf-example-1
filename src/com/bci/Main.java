package src.com.bci;

public class Main {

    public static void main(String[] args) throws NullPointerException {

        System.out.println("XIRR started...");

        double rate = new XIRR(
                new Transaction[]{
                        new Transaction(-1000, "2016-01-15"),
                        new Transaction(-1000, "2016-04-17"),
                        new Transaction(-2500, "2016-02-08"),
                        new Transaction(5050, "2016-08-24")
                }).XIRR();

        /*
         Some code above
         Put the exception-prone code here
         Some code below
        */

    }
}
