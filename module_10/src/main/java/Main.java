public class Main {
    private static final HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
    private static final UserCodeInput userCodeInput = new UserCodeInput();
    private static final String filePath = "module_10/src/main/resources/photo.jpg";

    public static void main(String[] args) {
        int statusCode = userCodeInput.getStatusCode();
        imageDownloader.downloadStatusImage(statusCode, filePath);
    }

}
