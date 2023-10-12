import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(TimeServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int paramValue = getParamValue(req);

        String responseTime = "Current time is: " + getTime(paramValue);
        String httpResponse = "<h3>" + responseTime + "+" + paramValue + "</h3>";

        resp.addHeader("Content-Type", "text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println(httpResponse);
        resp.getWriter().flush();
    }

    private String getTime(int paramValue) {
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);

        currentTime = currentTime.plusHours(paramValue);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss 'UTC'");
        return currentTime.format(formatter);
    }

    private int getParamValue(HttpServletRequest req) {
        String timezoneParam = req.getParameter("timezone");

        if (timezoneParam != null && !timezoneParam.isEmpty()) {
            String lastNumber = extractLastNumber(timezoneParam);

            if (lastNumber != null) {
                try {
                    return Integer.parseInt(lastNumber);
                } catch (NumberFormatException e) {
                    logger.info("Error\n" + e);
                }
            }
        }
        return 0;
    }

    private String extractLastNumber(String input) {
        String pattern = "(\\d+)$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        if (m.find()) {
            return m.group(1);
        } else {
            return null;
        }
    }
}
