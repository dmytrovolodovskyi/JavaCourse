package flyway;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection database;
    private Connection connection;

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/osbb_8";
    private static String username = "root";
    private static String password = "rootroot";

    private static String sqlResultQuery =
            "select " +
                "r.name, " +
                "r.email, " +
                "b.address, " +
                "f.number, " +
                "f.area " +
            "from " +
                "residents r " +
            "join " +
                "flats f on r.flat_id = f.id " +
            "join " +
                "buildings b on f.building_id = b.id " +
            "where " +
                "r.has_access = 0;";

    public static DBConnection getInstance() {
        if (database == null) {
            database = new DBConnection();
        }
        return database;
    }

    public DBConnection init() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        return this;
    }

    public List<String> readResultData() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlResultQuery);

        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData data = resultSet.getMetaData();

        ArrayList<String> result = new ArrayList();

        int columnCount = data.getColumnCount();

        while (resultSet.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) {
                    row.append(" | ");
                }
                row.append(resultSet.getString(i));
            }
            result.add(row.toString());
        }
        return result;
    }

}
