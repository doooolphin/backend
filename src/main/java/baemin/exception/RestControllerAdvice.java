package baemin.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResult> handleException(Exception e) {
        ErrorResult errorResult = ErrorResult.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(e.getMessage())
            .timeStamp(new Date())
            .build();
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
