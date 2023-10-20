import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/time*")
public class TimezoneValidateFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String timezoneParam = req.getParameter("timezone");

        if (timezoneParam != null) {
            boolean isMatches = timezoneParam.matches("UTC\\ [1-9]\\d*");
            if (isMatches) {
                chain.doFilter(req, resp);
            } else {
                resp.setStatus(404);
                resp.setContentType("application/json");
                resp.getWriter().write("{\"Error\": \"Incorrect value\"}");
                resp.getWriter().close();
            }
        }
    }

    }

