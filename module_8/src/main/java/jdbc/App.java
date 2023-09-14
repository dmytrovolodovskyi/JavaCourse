package jdbc;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = DBConnection.getInstance().init();
        insertDataIntoDB(connection);
        getValuesFromDB(connection);
    }

    private static void insertDataIntoDB(DBConnection connection) throws SQLException {
        for (int i = 1; i < 25; i++) {
            connection.crateBuildingsValue("street " + i);
            connection.crateFlatsValue(i, 100 + i, 60.0f, i);
            connection.crateMembersValue("Name " + i, i);
            connection.crateResidentsValue("Name " + i, "name" + i + "@gmail.com", true, i, i);
            connection.crateRolesValue("member", i);
        }
    }

    public static void getValuesFromDB(DBConnection connection) throws SQLException {
        int dataSize = connection.readResidentsData().size();

        for (int i = 0; i < dataSize; i++) {
            System.out.println(connection.readResidentsData().get(i));
        }
    }

}
