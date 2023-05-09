package isp.lab7.safehome;

public class InvalidPinException extends Exception {

    public InvalidPinException() {
        super("Invalid PIN entered.");
    }
}
