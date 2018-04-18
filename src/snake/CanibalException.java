package snake;

public class CanibalException extends Exception {
    public String getMessage() {
        return "Le serpent a mangé une partie de son corps";
    }
}
