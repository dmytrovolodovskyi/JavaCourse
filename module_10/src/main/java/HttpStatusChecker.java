import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class HttpStatusChecker {
    private static final Logger logger = Logger.getLogger(HttpStatusChecker.class.getName());


    public String getStatusImage(int statusCode) throws IOException {
        String imageURL = "https://http.cat/" + statusCode + ".jpg";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageURL).openConnection();
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                return imageURL;
            } else {
                throw new IOException("Image not found");
            }
        } catch (IOException e) {
            throw new IOException("There is no image for status code: " + statusCode);
        }
    }

}
