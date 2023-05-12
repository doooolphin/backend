package baemin.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MemberException extends RuntimeException{

    protected HttpStatus code;

    public MemberException(HttpStatus code,String message) {
        super(message);
        this.code = code;
    }
}
