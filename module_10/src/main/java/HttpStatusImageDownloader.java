import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    private static final String filePath = "module_10/src/main/resources/photo.jpg";

    public void downloadStatusImage(int statusCode) throws IOException {
        String imageURL = httpStatusChecker.getStatusImage(statusCode);

        Connection connection = Jsoup.connect(imageURL).ignoreContentType(true);

        try (InputStream inputStream = connection.execute().bodyStream();
             OutputStream outputStream = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
