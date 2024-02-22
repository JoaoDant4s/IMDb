package service.exception;

public class InvalidDatePatternException extends RuntimeException{
    public InvalidDatePatternException(String message, RuntimeException cause){super(message, cause);}
}
