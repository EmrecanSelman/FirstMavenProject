public class DAOEcxeption extends RuntimeException {

    public DAOEcxeption() {
        super("Failed to execute SQL statement, something unexpected happen.");
    }

    public DAOEcxeption(String message) {
        super(message);
    }

    public DAOEcxeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOEcxeption(Throwable cause) {
        super(cause);
    }
}
