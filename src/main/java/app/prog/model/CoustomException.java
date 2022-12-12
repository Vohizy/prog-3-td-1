package app.prog.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoustomException extends RuntimeException{
    public CoustomException(String messe){
        super (messe);
    }
}
