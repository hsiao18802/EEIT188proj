package tw.com.ispan.exception;

public class InvalidDiscountCodeException extends RuntimeException {
    public InvalidDiscountCodeException(String message) {
        super(message);
    }
}