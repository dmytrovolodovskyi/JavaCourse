import java.util.Scanner;
import java.util.logging.Logger;

public class UserCodeInput {
    private static final Logger logger = Logger.getLogger(UserCodeInput.class.getName());

    public static int getStatusCode() {
        logger.info("Enter status code: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();

        try {
            return Integer.parseInt(userAnswer);
        } catch (NumberFormatException e) {
            logger.info("Please, enter valid number");
        }
        return 404;
    }
}
