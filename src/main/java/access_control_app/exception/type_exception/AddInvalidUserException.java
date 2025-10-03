package access_control_app.exception.type_exception;

public class AddInvalidUserException extends RuntimeException {
    public AddInvalidUserException(String message) {
        super(message);
    }
}
