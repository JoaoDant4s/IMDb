package service;

import service.exception.InvalidDatePatternException;
import service.exception.InvalidModelException;
import service.exception.ServiceException;
import util.DateConverter;

import java.time.LocalDate;

public abstract class AbstractPersonService {
    public void validate(String name, String birthString, String className){
        if(name == null || birthString == null){
            throw new InvalidModelException(className + " informado com campo nulo");
        }
    }

    public LocalDate convertDate(String birthString){
        LocalDate birthDate;
        try{
            birthDate = DateConverter.formatDateStringByPattern(birthString, "dd/MM/yyyy");
        } catch(InvalidDatePatternException exception){
            throw new ServiceException(exception.getMessage(), exception);
        }
        return birthDate;
    }
}
