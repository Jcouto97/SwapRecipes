package mindera.midswap.SwapRecipes.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(AlreadyExistsException.class)
//    public ResponseEntity<Object> carAlreadyExistsExceptionHandler(AlreadyExistsException exception, HttpServletRequest request){
//        return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(buildError(exception, request, HttpStatus.CONFLICT.toString()));
//    }


//    @ExceptionHandler(UserIdentificationNumberAlreadyExistsException.class)
//    public ResponseEntity<Object> carAlreadyExistsExceptionHandler(UserIdentificationNumberAlreadyExistsException exception,
//                                                                   HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(buildError(exception, request, HttpStatus.CONFLICT.toString()));
//    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException exception,
                                                               HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(exception, request, HttpStatus.NOT_FOUND.toString()));
    }


//    @ExceptionHandler(RentNotFoundException.class)
//    public ResponseEntity<Object> rentNotFoundExceptionHandler(RentNotFoundException exception, HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                //                                        String "statusCode": "404 NOT_FOUND"
//                .body(buildError(exception, request, HttpStatus.NOT_FOUND.toString()));
//    }
//
//
//    @ExceptionHandler(RentedVehicleNotReturnedYetException.class)
//    public ResponseEntity<Object> rentedCarNotReturnedYetExceptionHandler(RentedVehicleNotReturnedYetException exception, HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(buildError(exception, request, HttpStatus.CONFLICT.toString()));
//    }
//
//    @ExceptionHandler(FieldCannotBeEmptyException.class)
//    public ResponseEntity<Object> fieldCannotBeEmptyExceptionHandler(FieldCannotBeEmptyException exception, HttpServletRequest request){
//        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED)
//                .body(buildError(exception, request, HttpStatus.LENGTH_REQUIRED.toString()));
//    }


    //está a ser feito no .body!
    //                                                      String "statusCode": "404 NOT_FOUND"
    private Error buildError(Exception e, HttpServletRequest request, String statusCode){
        return Error.builder()
                .timestamp(new Date())
                .verb(request.getMethod())
                .path(request.getRequestURI())
                .statusCode(statusCode)
                .message(e.getMessage()) //vai buscar a msg que vem da exception
                .build();
    }

}