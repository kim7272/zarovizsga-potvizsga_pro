package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;
    private PreparedStatement stmt;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            return getIP(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

        public String getIP (PreparedStatement stmt){

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    String ipCode = rs.getString("ip_address");
                    return ipCode;
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        }
    }
