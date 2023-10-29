package utils;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    private FlywayMigration() {

    }

    public static void migrateDb() {
        Flyway.configure()
                .dataSource(Config.JDBC_URL, Config.USERNAME, Config.PASSWORD)
                .locations("classpath:flyway.scripts")
                .load()
                .migrate();
    }
}
