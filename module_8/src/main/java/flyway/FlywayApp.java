package flyway;

import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class FlywayApp {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/osbb_8";
    private static String username = "root";
    private static String password = "rootroot";

    public static void main(String[] args) throws SQLException {
        DBConnection dbConnection = DBConnection.getInstance().init();
        List<String> resultData = dbConnection.readResultData();

        System.out.println(" Name  |      email      | address  | num | area");
        System.out.println("--------------------------------------------------");
        for (String row : resultData) {
            System.out.println(row);
        }

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway.scripts")
                .load()
                .migrate();
    }
}
