package exception;

public class PostgresClassNotFoundException extends RuntimeException{
    public PostgresClassNotFoundException(String message) {
        super(message);
    }
}
