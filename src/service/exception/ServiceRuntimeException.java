package service.exception;

public class ServiceRuntimeException extends RuntimeException{
    public ServiceRuntimeException(String message, RuntimeException cause){ super(message, cause);}
}
