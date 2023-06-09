package app.support.utils;

import java.sql.*;
import java.util.Map;

import static org.testng.util.Strings.valueOf;

public class PgSql {
    public static Connection conn;
    private static Statement stmt;
    Map<String, Map<String, String>> datayml;

    public PgSql() throws SQLException {

        try {

            Yaml yml = new Yaml("config");
            datayml = yml.getFile();

            conn = DriverManager.getConnection(
                    "jdbc:postgresql://" + datayml.get("pgip") + ":" + datayml.get("pgport") + "/" + datayml.get("pgdb"), String.valueOf(datayml.get("pguser")), String.valueOf(datayml.get("pgpassword")));

            stmt = conn.createStatement();


            if (conn != null) {
                System.out.println("Connected to the database!");

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listUsers() throws SQLException {

        String sql = "SELECT \"KUNNR\" FROM \"Caja\".\"ZNCSAP\"\n" +
                "ORDER BY \"FECHA\" DESC LIMIT 100";


        ResultSet rs = stmt.executeQuery(sql);

        System.out.println(rs);

        while (rs.next()) {
            System.out.println(rs.getString("KUNNR"));
        }
    }

    public String getRandomSapUser() throws SQLException {

        String sql = "SELECT RANDOM() as orden, \"KUNNR\" FROM \"Caja\".\"ZNCSAP\"\n" +
                "ORDER BY orden LIMIT 1";

        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getString("KUNNR");

    }
}
