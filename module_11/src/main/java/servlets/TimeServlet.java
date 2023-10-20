package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        String paramValue = getParamValue(req, resp);

        String responseTime = "Current time is: " + getCurrentTime(paramValue);
        String httpResponse = "<h3>" + responseTime + "+" + paramValue + "</h3>";

        resp.addHeader("Content-Type", "text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println(httpResponse);
        resp.getWriter().flush();
    }

    private String getParamValue(HttpServletRequest req, HttpServletResponse resp) {
        String timezoneParam = req.getParameter("timezone");

        if (timezoneParam != null && !timezoneParam.trim().isEmpty()) {
            String timezoneNumber = extractLastNumber(timezoneParam);

            Cookie timezoneCookie = new Cookie("lastTimezone", timezoneNumber);
            timezoneCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(timezoneCookie);
            return timezoneNumber;
        } else {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("lastTimezone".equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return "0";
    }

    private String getCurrentTime(String timezoneValue) {
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        currentTime = currentTime.plusHours(Integer.parseInt(timezoneValue));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss 'UTC'");
        return currentTime.format(formatter);
    }

    private String extractLastNumber(String input) {
        String pattern = "(\\d+)$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        return m.find() ? m.group(1) : null;
    }
}
