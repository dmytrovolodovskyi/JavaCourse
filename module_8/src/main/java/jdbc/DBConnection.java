package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection database;
    private Connection connection;

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/osbb";
    private static String username = "root";
    private static String password = "rootroot";

    private static String sqlCreateBuildingsQuery =
            "INSERT INTO buildings(address) VALUE (?);";
    private static String sqlCreateFlatsQuery =
            "INSERT INTO flats(floor, number, area, building_id) VALUE (?, ?, ?, ?);";
    private static String sqlCreateMembersQuery =
            "INSERT INTO members(name, flat_id) VALUE (?, ?);";
    private static String sqlCreateResidentsQuery =
            "INSERT INTO residents(name, email, has_access, member_id, flat_id) VALUE (?, ?, ?, ?, ?);";
    private static String sqlCreateRolesQuery =
            "INSERT INTO roles(role, member_id) VALUE (?, ?);";

    private static String sqlReadQuery =
            "SELECT * FROM residents";

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

    public void crateBuildingsValue(String address) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateBuildingsQuery);
        preparedStatement.setString(1, address);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void crateFlatsValue(int floor, int number, float area, int building_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateFlatsQuery);
        preparedStatement.setInt(1, floor);
        preparedStatement.setInt(2, number);
        preparedStatement.setFloat(3, area);
        preparedStatement.setInt(4, building_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void crateMembersValue(String name, int flat_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateMembersQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, flat_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void crateResidentsValue(String name, String email, boolean has_access, int member_id, int flat_id)
            throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateResidentsQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setBoolean(3, has_access);
        preparedStatement.setInt(4, member_id);
        preparedStatement.setInt(5, flat_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public void crateRolesValue(String role, int member_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateRolesQuery);
        preparedStatement.setString(1, role);
        preparedStatement.setInt(2, member_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public List<String> readResidentsData() throws SQLException     {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlReadQuery);

        ArrayList<String> result = new ArrayList();

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            result.add(resultSet.getString("name"));
            result.add(resultSet.getString("email"));
            result.add(resultSet.getString("has_access"));
        }
        return result;
    }

    public void update(String oldValue, String newValue) {

    }

    public void delete(String value) {

    }
}
