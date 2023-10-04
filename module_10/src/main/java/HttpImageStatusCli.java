import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class HttpImageStatusCli {
    private static final Logger logger = Logger.getLogger(HttpImageStatusCli.class.getName());
    private static final HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();

    public void askStatus() {
        logger.info("Enter status code: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();

        try {
            int statusCode = Integer.parseInt(userAnswer);
            imageDownloader.downloadStatusImage(statusCode);
        } catch (NumberFormatException e) {
            logger.info("Please, enter a valid number");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
