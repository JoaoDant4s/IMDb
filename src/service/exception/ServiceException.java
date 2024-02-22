package service.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String message, RuntimeException cause){ super(message, cause);}
}
