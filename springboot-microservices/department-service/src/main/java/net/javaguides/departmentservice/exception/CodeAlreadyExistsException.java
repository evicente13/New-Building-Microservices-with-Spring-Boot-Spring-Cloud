package net.javaguides.departmentservice.exception;

public class CodeAlreadyExistsException extends RuntimeException {
    private String message;

    public CodeAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
