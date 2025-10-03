package access_control_app.exception;

import access_control_app.exception.type_exception.AddInvalidUserException;
import access_control_app.exception.type_exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandling {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException ex)
    {
        ApiError apiError = new ApiError();
        apiError.setMessage(ex.getMessage());
        apiError.setCode(HttpStatus.NOT_FOUND.value());
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(AddInvalidUserException.class)
    public ResponseEntity<ApiError> handleAddInvalidUserException(AddInvalidUserException e)
    {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.BAD_REQUEST.value());
        apiError.setTimestamp(LocalDateTime.now());

        return  new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }



}